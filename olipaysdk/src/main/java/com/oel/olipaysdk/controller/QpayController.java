package com.oel.olipaysdk.controller;

import android.content.Context;
import android.util.Log;

import com.nexgo.oaf.apiv3.emv.EmvHandler2;
import com.oel.olipaysdk.client.QpayClientConnectionException;
import com.oel.olipaysdk.client.QpayClientConnectionLostException;
import com.oel.olipaysdk.client.QpayClientGeneralException;
import com.oel.olipaysdk.client.QpayClientSoapFaultException;
import com.oel.olipaysdk.utils.AndroidUtils;
import com.oel.olipaysdk.utils.Convert;
import com.urovo.i9000s.api.emv.ContantPara;
import com.urovo.i9000s.api.emv.EmvNfcKernelApi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;
import io.sentry.event.interfaces.StackTraceInterface;

public class QpayController {
    private Context context;
    protected static SentryClient sentry;
    private QpParamsMemory paramsMemory;
    private boolean debugModeEnabled;
    private QpProcess qpProcess;
    private QpLocale qpLocale;
    private boolean removeCardHint = false;
    private boolean cancelRealizaTransaccion = false;
    private LoggedQpayControlEventosImpl qpListener;
    private final EmvNfcKernelApi emvApi;
    private EmvHandler2 emvHandler2;
    private QpayController(){
        this.emvApi = EmvNfcKernelApi.getInstance();
    }

    public String qpRealizaTransaccion(final Context context, final String identificador, final String contrasena, final double monto, final double propina, final String referencia, final int diferimiento, final int plan, final int numeroPagos) throws TransactionOngoingException {

        this.context = context;
        final String deviceId = AndroidUtils.getSerialNumber();
        final String transaccionId = TransactionId.generate();
    //un comentario

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    startQpProcess(QpProcess.REALIZA_TRANSACCION);
                    qpMostrarEstadoTexto(QpEstradoTexto.APPROACH_INSERT_SLIDE_CARD.description(qpLocale), QpEstradoTexto.APPROACH_INSERT_SLIDE_CARD.code());
                    paramsMemory = new QpParamsMemory();
                    paramsMemory.identificador = identificador;
                    paramsMemory.contrasena = contrasena;
                    paramsMemory.monto = monto;
                    paramsMemory.propina = propina;
                    paramsMemory.transaccionId = transaccionId;
                    paramsMemory.referencia = referencia;
                    paramsMemory.diferimiento = diferimiento;
                    paramsMemory.plan = plan;
                    paramsMemory.numeroPagos = numeroPagos;
                    paramsMemory.deviceId = deviceId;
                    emvApi.setContext(context);  // offline pin need this
                    checkCard();
                } catch (Exception e) {
                    handleException(e, "Exception when creating transaction", "qpRealizaTransaccion", transaccionId, true);
                }
            }
        }).start();

        return transaccionId;
    }

    private void checkCard() {
        if (isDebugModeEnabled()) Log.d("Qpay", "checkCard called");
        if (cancelRealizaTransaccion) {
            cancelRealizaTransaccion = false;
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError(QpError.TRANSACTION_CANCELLED)")
                    .build());
            sendSentryInfoEvent("Cancelled out when reading card", "qpRealizaTransaccion");
            endQpProcess();
            qpListener.qpError(QpError.TRANSACTION_CANCELLED.description(qpLocale), QpError.TRANSACTION_CANCELLED.code(), removeCardHint, paramsMemory.transaccionId);
            return;
        }
        Hashtable<String, Object> data = new Hashtable<>();
        data.put("checkCardMode", ContantPara.CheckCardMode.SWIPE_OR_INSERT_OR_TAP);
        data.put("currencyCode", "484");
        data.put("amount", BigDecimal.valueOf(paramsMemory.monto).setScale(2, RoundingMode.HALF_UP).toPlainString());
        data.put("cashbackAmount", "0");
        data.put("checkCardTimeout", "30");
        data.put("FallbackSwitch", "1");
//        data.put("FallbackSwitch", needFallbackMemory ? "1" : "0"); // needed for amex certification
        try {
            emvApi.startKernel(data);
        } catch (Exception e) {
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("emvApi.checkCard threw Exception")
                    .withData("exception", e.getClass().getName())
                    .withData("exceptionMessage", e.getMessage())
                    .build());
            qpMostrarEstadoTexto(QpEstradoTexto.ERROR_TRY_AGAIN.description(qpLocale), QpEstradoTexto.ERROR_TRY_AGAIN.code());
            e.printStackTrace();
            if(sleepAndCheckForCancelRealizaTransaccion(1000)) return;
            checkCard();
        }
    }

    private boolean sleepAndCheckForCancelRealizaTransaccion(long millis) {
        boolean cancelled = cancelRealizaTransaccion;

        long millisSlept = 0;
        while (millisSlept < millis && !cancelled) {
            sleep(100);
            millisSlept = millisSlept + 100;
            if (cancelRealizaTransaccion) cancelled = true;
        }

        if (cancelled) {
            cancelRealizaTransaccion = false;
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError(QpError.TRANSACTION_CANCELLED)")
                    .build());
            sendSentryInfoEvent("Cancelled out when reading card", "qpRealizaTransaccion");
            endQpProcess();
            qpListener.qpError(QpError.TRANSACTION_CANCELLED.description(qpLocale), QpError.TRANSACTION_CANCELLED.code(), removeCardHint, paramsMemory.transaccionId);
            return true;
        } else {
            return false;
        }
    }

    private void sendSentryInfoEvent(String message, String transaction) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage(message)
                .withData("transaction", transaction)
                .build());
        sentry.sendEvent(new EventBuilder()
                .withMessage(message)
                .withTransaction(transaction)
                .withLevel(Event.Level.INFO)
                .withSentryInterface(new StackTraceInterface(new Throwable().getStackTrace())));
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Log.d("Qpay", "sleeping" + millis +  "ms failed, since InterruptedException. ignoring silently");
        }
    }

    private void sendSentryExceptionEvent(Throwable throwable, String message, String transaction) {
        sentry.sendEvent(new EventBuilder()
                .withMessage(message)
                .withTransaction(transaction)
                .withLevel(Event.Level.ERROR)
                .withTag("exception", throwable.getClass().getName())
                .withExtra("exception", throwable.getClass().getName())
                .withExtra("exceptionMessage", throwable.getMessage())
                .withSentryInterface(new StackTraceInterface(throwable.getStackTrace())));
    }

    private void endQpProcess() {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("endQpProcess").build());
        sentry.getContext().clearUser();
        sentry.getContext().clearTags();
        qpProcess = null;
    }

    private void handleException(Exception e, String numeroTransaccion, String message, String transaction) {
        handleException(e, numeroTransaccion, message, transaction, false);
    }

    private void handleException(Exception e, String numeroTransaccion, String message, String transaction, boolean endProcess) {
        if (isDebugModeEnabled()) Log.d("Qpay", "handleException: " + e.getMessage());
        e.printStackTrace();
        sentry.getContext().addTag("exception", e.getClass().getName());
        if (e.getCause() != null) sentry.getContext().addTag("exceptionCause", e.getCause().getClass().getName());
        sentry.getContext().addTag("exceptionMessage", e.getMessage());
        if (e instanceof QpayClientSoapFaultException) {
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError")
                    .withData("resultado", QpError.QPAY_CLIENT_SOAP_FAULT_ERROR.description(qpLocale))
                    .withData("codigo", Convert.toString(QpError.QPAY_CLIENT_SOAP_FAULT_ERROR.code()))
                    .withData("removeCardHint", Convert.toString(removeCardHint))
                    .withData("numeroTransaccion", numeroTransaccion)
                    .build());
            sendSentryExceptionEvent(e, message, transaction);
            sentry.getContext().removeTag("exception");
            sentry.getContext().removeTag("exceptionCause");
            sentry.getContext().removeTag("exceptionMessage");
            if (endProcess) endQpProcess();
            qpListener.qpError(QpError.QPAY_CLIENT_SOAP_FAULT_ERROR.description(qpLocale), QpError.QPAY_CLIENT_SOAP_FAULT_ERROR.code(), removeCardHint, numeroTransaccion);
            return;
        }
        if (e instanceof QpayClientConnectionException) {
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError")
                    .withData("resultado", QpError.NO_CONNECTION_ERROR.description(qpLocale))
                    .withData("codigo", Convert.toString(QpError.NO_CONNECTION_ERROR.code()))
                    .withData("removeCardHint", Convert.toString(removeCardHint))
                    .withData("numeroTransaccion", numeroTransaccion)
                    .build());
            sendSentryExceptionEvent(e, message, transaction);
            sentry.getContext().removeTag("exception");
            sentry.getContext().removeTag("exceptionCause");
            sentry.getContext().removeTag("exceptionMessage");
            if (endProcess) endQpProcess();
            qpListener.qpError(QpError.NO_CONNECTION_ERROR.description(qpLocale), QpError.NO_CONNECTION_ERROR.code(), removeCardHint, numeroTransaccion);
            return;
        }
        if (e instanceof QpayClientConnectionLostException) {
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError")
                    .withData("resultado", QpError.CONNECTION_LOST_ERROR.description(qpLocale))
                    .withData("codigo", Convert.toString(QpError.CONNECTION_LOST_ERROR.code()))
                    .withData("removeCardHint", Convert.toString(removeCardHint))
                    .withData("numeroTransaccion", numeroTransaccion)
                    .build());
            sendSentryExceptionEvent(e, message, transaction);
            sentry.getContext().removeTag("exception");
            sentry.getContext().removeTag("exceptionCause");
            sentry.getContext().removeTag("exceptionMessage");
            if (endProcess) endQpProcess();
            qpListener.qpError(QpError.CONNECTION_LOST_ERROR.description(qpLocale), QpError.CONNECTION_LOST_ERROR.code(), removeCardHint, numeroTransaccion);
            return;
        }
        if (e instanceof QpayClientGeneralException) {
            sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpListener.qpError")
                    .withData("resultado", QpError.QPAY_CLIENT_GENERAL_ERROR.description(qpLocale))
                    .withData("codigo", Convert.toString(QpError.QPAY_CLIENT_GENERAL_ERROR.code()))
                    .withData("removeCardHint", Convert.toString(removeCardHint))
                    .withData("numeroTransaccion", numeroTransaccion)
                    .build());
            sendSentryExceptionEvent(e, message, transaction);
            sentry.getContext().removeTag("exception");
            sentry.getContext().removeTag("exceptionCause");
            sentry.getContext().removeTag("exceptionMessage");
            if (endProcess) endQpProcess();
            qpListener.qpError(QpError.QPAY_CLIENT_GENERAL_ERROR.description(qpLocale), QpError.QPAY_CLIENT_GENERAL_ERROR.code(), removeCardHint, numeroTransaccion);
            return;
        }
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("qpListener.qpError")
                .withData("resultado", QpError.UNKNOWN_ERROR.description(qpLocale))
                .withData("codigo", Convert.toString(QpError.UNKNOWN_ERROR.code()))
                .withData("removeCardHint", Convert.toString(removeCardHint))
                .withData("numeroTransaccion", numeroTransaccion)
                .build());
        sendSentryExceptionEvent(e, message, transaction);
        sentry.getContext().removeTag("exception");
        sentry.getContext().removeTag("exceptionCause");
        sentry.getContext().removeTag("exceptionMessage");
        if (endProcess) endQpProcess();
        qpListener.qpError(QpError.UNKNOWN_ERROR.description(qpLocale), QpError.UNKNOWN_ERROR.code(), removeCardHint, numeroTransaccion);
    }


    public QpayControlEventos getQpListener() {
        return qpListener;
    }

    public boolean isDebugModeEnabled() {
        return debugModeEnabled;
    }


    public interface QpayControlEventos {

        void qpInicializado();

        void qpMostrarEstadoTexto(String resultado, int codigo);

        void qpRegresaTransaccion(HashMap<String, String> resultado);

        void qpRegresaFirma(HashMap<String, String> resultado);

        void qpRegresaEnviaVoucher(HashMap<String, String> resultado);

        void qpRegresaPrintVoucher(HashMap<String, String> resultado);

        void qpRegresaPrintLote();

        void qpRegresaCancelacion(HashMap<String, String> resultado);

        void qpRegresaDevolucion(HashMap<String, String> resultado);

        void qpRegresaPreAutorizacion(HashMap<String, String> resultado);

        void qpRegresaPostAutorizacion(HashMap<String, String> resultado);

        void qpRegresaReAutorizacion(HashMap<String, String> resultado);

        void qpRegresaCancelacionPreAutorizacion(HashMap<String, String> resultado);

        void qpRegresaVentaECommerce(HashMap<String, String> resultado);

        void qpRegresaDevolucionECommerce(HashMap<String, String> resultado);

        void qpRegresaCancelacionECommerce(HashMap<String, String> resultado);

        void qpRegresaHistorial(List<HashMap<String, String>> resultado);

        void qpRegresaHistorialTransaccion(HashMap<String, String> resultado);

        void qpError(String resultado, int codigo, boolean removeCardHint, String numeroTransaccion);

        void emvEvent(String eventName, Map<String, Object> data);

        /**
         * @Deprecated not available any more, will be removed in the future
         */
        @Deprecated
        void qpRegresaReversa(HashMap<String, String> resultado);

    }

    private void qpMostrarEstadoTexto(String resultado, int codigo) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("qpListener.qpMostrarEstadoTexto")
                .withData("resultado", resultado)
                .withData("codigo", Convert.toString(codigo))
                .build());
        qpListener.qpMostrarEstadoTexto(resultado, codigo);
    }

    private void startQpProcess(QpProcess process) {
        sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                .setMessage("startQpProcess")
                .withData("process", process.name())
                .build());
        qpProcess = process;
    }
}
