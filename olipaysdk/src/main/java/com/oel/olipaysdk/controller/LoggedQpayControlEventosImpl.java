package com.oel.olipaysdk.controller;

import android.util.Log;

import com.oel.olipaysdk.utils.Convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.sentry.SentryClient;
import io.sentry.event.BreadcrumbBuilder;

public class LoggedQpayControlEventosImpl implements QpayController.QpayControlEventos {

    private QpayController.QpayControlEventos qpListener;
    private SentryClient sentry;
    private boolean debugModeEnabled;

    public void setDebugModeEnabled(boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
    }

    public LoggedQpayControlEventosImpl(QpayController.QpayControlEventos qpListener, SentryClient sentry, boolean debugModeEnabled) {
        this.qpListener = qpListener;
        this.sentry = sentry;
        this.debugModeEnabled = debugModeEnabled;
    }

    @Override
    public void qpInicializado() {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpInicializado");
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpInicializado")
                    .build());
        }
        this.qpListener.qpInicializado();
    }

    @Override
    public void qpMostrarEstadoTexto(String resultado, int codigo) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpMostrarEstadoTexto resultado=" + resultado + "  codigo=" + codigo);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpMostrarEstadoTexto")
                    .withData("resultado", resultado)
                    .withData("codigo", Integer.toString(codigo))
                    .build());
        }
        this.qpListener.qpMostrarEstadoTexto(resultado, codigo);
    }

    @Override
    public void qpRegresaTransaccion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaTransaccion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaTransaccion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaTransaccion(resultado);
    }

    @Override
    public void qpRegresaFirma(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaFirma resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaFirma")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaFirma(resultado);
    }

    @Override
    public void qpRegresaEnviaVoucher(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaEnviaVoucher resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaEnviaVoucher")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaEnviaVoucher(resultado);
    }

    @Override
    public void qpRegresaPrintVoucher(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaPrintVoucher resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaPrintVoucher")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaPrintVoucher(resultado);
    }

    @Override
    public void qpRegresaPrintLote() {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaPrintLote");
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaPrintLote")
                    .build());
        }
        this.qpListener.qpRegresaPrintLote();
    }

    @Override
    public void qpRegresaCancelacion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaCancelacion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaCancelacion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaCancelacion(resultado);
    }

    @Override
    public void qpRegresaDevolucion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaDevolucion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaDevolucion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaDevolucion(resultado);
    }

    @Override
    public void qpRegresaPreAutorizacion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaPreAutorizacion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaPreAutorizacion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaPreAutorizacion(resultado);
    }

    @Override
    public void qpRegresaPostAutorizacion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaPostAutorizacion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaPostAutorizacion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaPostAutorizacion(resultado);
    }

    @Override
    public void qpRegresaReAutorizacion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaReAutorizacion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaReAutorizacion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaReAutorizacion(resultado);
    }

    @Override
    public void qpRegresaCancelacionPreAutorizacion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaCancelacionPreAutorizacion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaCancelacionPreAutorizacion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaCancelacionPreAutorizacion(resultado);
    }

    @Override
    public void qpRegresaVentaECommerce(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaVentaECommerce resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaVentaECommerce")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaVentaECommerce(resultado);
    }

    @Override
    public void qpRegresaDevolucionECommerce(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaDevolucionECommerce resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaDevolucionECommerce")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaDevolucionECommerce(resultado);
    }

    @Override
    public void qpRegresaCancelacionECommerce(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaCancelacionECommerce resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaCancelacionECommerce")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaCancelacionECommerce(resultado);
    }

    @Override
    public void qpRegresaHistorial(List<HashMap<String, String>> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaHistorial resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaHistorial")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaHistorial(resultado);
    }

    @Override
    public void qpRegresaHistorialTransaccion(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaHistorialTransaccion resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaHistorialTransaccion")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaHistorialTransaccion(resultado);
    }

    @Override
    public void qpError(String resultado, int codigo, boolean removeCardHint, String numeroTransaccion) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpError resultado=" + resultado + "  codigo=" + codigo + " removeCardHint=" + removeCardHint + " numeroTransaccion=" + numeroTransaccion);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpError")
                    .withData("resultado", resultado)
                    .withData("codigo", Integer.toString(codigo))
                    .withData("removeCardHint", Boolean.toString(removeCardHint))
                    .withData("numeroTransaccion", numeroTransaccion)
                    .build());

        }
        this.qpListener.qpError(resultado, codigo, removeCardHint, numeroTransaccion);
    }

    @Override
    public void emvEvent(String eventName, Map<String, Object> data) {
        if(debugModeEnabled) {
            Log.d("Qpay", "emvEvent eventName=" + eventName + "  data=" + data);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("emvEvent")
                    .withData("eventName", eventName)
                    .withData("data", Convert.toString(data))
                    .build());
        }
        this.qpListener.emvEvent(eventName, data);
    }

    /**
     * @Deprecated not available any more, will be removed in the future
     */
    @Deprecated
    @Override
    public void qpRegresaReversa(HashMap<String, String> resultado) {
        if(debugModeEnabled) {
            Log.d("Qpay", "qpRegresaReversa resultado=" + resultado);
            this.sentry.getContext().recordBreadcrumb(new BreadcrumbBuilder()
                    .setMessage("qpRegresaReversa")
                    .withData("resultado", Convert.toString(resultado))
                    .build());
        }
        this.qpListener.qpRegresaReversa(resultado);
    }

}

