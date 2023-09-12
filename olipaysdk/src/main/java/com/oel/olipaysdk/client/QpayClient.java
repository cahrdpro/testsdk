package com.oel.olipaysdk.client;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.MarshalDate;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;

import javax.net.ssl.SSLException;

import io.sentry.SentryClient;

public class QpayClient {

    public static final String NAMESPACE = "https://servidorseguro.operacionesenlinea.com/";
    private static final String QPAY_OP_KEY_1 = "kld8hfhkjsf";
    private static final String QPAY_OP_KEY_2 = "8346765hdhryyu";
    private static final String TEST_URL = "https://servertest.operacionesenlinea.com/gateway/OpGateway.asmx?wsdl";
    private static final String VGS_URL = "https://tntlklvie5g.SANDBOX.verygoodproxy.com/OpGateway.asmx?wsdl";
    private static final String PROD_URL = "https://servidorseguro.operacionesenlinea.com/gateway/OpGateway.asmx?wsdl";
    private static final String PROD_URL_NON_VGS = "https://gateway-live-openlinea.azurewebsites.net/OpGateway.asmx?wsdl";
    private static final String PROD_URL_VGS = "https://tntkerpanti.live.verygoodproxy.com/OpGateway.asmx?wsdl";
    private static final int SOAP_ENVELOPE_VERSION = SoapEnvelope.VER11;
    private static final int TIMEOUT = 120_000;

    private QpAmbiente qpAmbiente;
    private String qpUrl;
    private boolean vgsEnabled = false;
    private boolean debugModeEnabled;

    public String debugRequest;
    public String debugResponse;
    private SentryClient sentry;

    public QpayClient() {
        this(QpAmbiente.TEST, false);
    }

    public QpayClient(QpAmbiente qpAmbiente) {
        this(qpAmbiente, false);
    }

    public QpayClient(QpAmbiente qpAmbiente, boolean debugModeEnabled) {
        this(qpAmbiente, null, debugModeEnabled);
    }

    public QpayClient(QpAmbiente qpAmbiente, String qpUrl) {
        this(qpAmbiente, qpUrl, false);
    }

    public QpayClient(QpAmbiente qpAmbiente, String qpUrl, boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
        this.qpAmbiente = qpAmbiente;
        this.qpUrl = qpUrl;
    }

    public void configureSentry(SentryClient sentry) {
        this.sentry = sentry;
    }

    public void setQpAmbiente(QpAmbiente qpAmbiente) {
        this.qpAmbiente = qpAmbiente;
    }

    public QpAmbiente getQpAmbiente() {
        return this.qpAmbiente;
    }

    public boolean isVgsEnabled() {
        return vgsEnabled;
    }

    public void setVgsEnabled(boolean vgsEnabled) {
        this.vgsEnabled = vgsEnabled;
    }

    public boolean isDebugModeEnabled() {
        return debugModeEnabled;
    }

    public void setDebugModeEnabled(boolean debugModeEnabled) {
        this.debugModeEnabled = debugModeEnabled;
    }

    public void setQpUrl(String qpUrl) {
        this.qpUrl = qpUrl;
    }

    public String getQpUrl(boolean isVgsOperation) {
        if (qpUrl != null) {
            return qpUrl;
        } else {
            if (qpAmbiente == QpAmbiente.TEST) {
                return TEST_URL;
            } else if (qpAmbiente == QpAmbiente.VGS) {
                return VGS_URL;
            } else if (qpAmbiente == QpAmbiente.VGS_LIVE) {
                if (isVgsOperation) {
                    return PROD_URL_VGS;
                } else {
                    return PROD_URL_NON_VGS;
                }
            } else {
                if (vgsEnabled) {
                    if (isVgsOperation) {
                        return PROD_URL_VGS;
                    } else {
                        return PROD_URL_NON_VGS;
                    }
                }
                return PROD_URL;
            }
        }
    }

    public OpVersionResponse opVersion() {
        SoapObject soapResponse = makeSoapCall("OpVersion");
        return OpVersionConverter.soapObjectToResponsePojo(soapResponse);
    }

    public OpVentaResponse opVenta(OpVentaRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opVenta");
        if (sentry != null) OpVentaSentryLogger.logBreadcrumbRequest(request, getQpUrl(true), sentry);
        SoapObject soapRequest = OpVentaConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpVenta", soapRequest, true);
        OpVentaResponse response = OpVentaConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpVentaSentryLogger.logBreadcrumbResponse(response, getQpUrl(true), sentry);
        return response;
    }

    public Map<String, Object> opVenta(Map<String, Object> request) {
        return OpVentaConverter.responsePojoToMap(opVenta(OpVentaConverter.requestMapToPojo(request)));
    }

    public OpFirmaResponse opFirma(OpFirmaRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opFirma");
        if (sentry != null) OpFirmaSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpFirmaConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpFirma", soapRequest);
        OpFirmaResponse response = OpFirmaConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpFirmaSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public EnviaVoucherResponse enviaVoucher(EnviaVoucherRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "enviaVoucher");
        if (sentry != null) EnviaVoucherSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = EnviaVoucherConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("enviaVoucher", soapRequest);
        EnviaVoucherResponse response = EnviaVoucherConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) EnviaVoucherSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public EnviaVoucherImagenResponse enviaVoucherImagen(EnviaVoucherImagenRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "enviaVoucherImagen");
        if (sentry != null) EnviaVoucherImagenSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = EnviaVoucherImagenConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("enviaVoucherImagen", soapRequest);
        EnviaVoucherImagenResponse response = EnviaVoucherImagenConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) EnviaVoucherImagenSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public RecurrentesCargoResponse recurrentesCargo(RecurrentesCargoRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "recurrentesCargo");
        if (sentry != null) RecurrentesCargoSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = RecurrentesCargoConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("recurrentesCargo", soapRequest);
        RecurrentesCargoResponse response = RecurrentesCargoConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) RecurrentesCargoSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpCancelacionResponse opCancelacion(OpCancelacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opCancelacion");
        if (sentry != null) OpCancelacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpCancelacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpCancelacion", soapRequest);
        OpCancelacionResponse response = OpCancelacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpCancelacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpDevolucionResponse opDevolucion(OpDevolucionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opDevolucion");
        if (sentry != null) OpDevolucionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpDevolucionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpDevolucion", soapRequest);
        OpDevolucionResponse response = OpDevolucionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpDevolucionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public EcommerceVentaResponse ecommerceVenta(EcommerceVentaRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "ecommerceVenta");
        if (sentry != null) EcommerceVentaSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = EcommerceVentaConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("ecommerceVenta", soapRequest);
        EcommerceVentaResponse response = EcommerceVentaConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) EcommerceVentaSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public EcommerceCancelacionResponse ecommerceCancelacion(EcommerceCancelacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "ecommerceCancelacion");
        if (sentry != null) EcommerceCancelacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = EcommerceCancelacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("ecommerceCancelacion", soapRequest);
        EcommerceCancelacionResponse response = EcommerceCancelacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) EcommerceCancelacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public EcommerceDevolucionResponse ecommerceDevolucion(EcommerceDevolucionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "ecommerceDevolucion");
        if (sentry != null) EcommerceDevolucionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = EcommerceDevolucionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("ecommerceDevolucion", soapRequest);
        EcommerceDevolucionResponse response = EcommerceDevolucionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) EcommerceDevolucionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpEstadoCuentaResponse opEstadoCuenta(OpEstadoCuentaRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opEstadoCuenta");
        if (sentry != null) OpEstadoCuentaSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpEstadoCuentaConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpEstadoCuenta", soapRequest);
        OpEstadoCuentaResponse response = OpEstadoCuentaConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpEstadoCuentaSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpPostAutorizacionResponse opPostAutorizacion(OpPostAutorizacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opPostAutorizacion");
        if (sentry != null) OpPostAutorizacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpPostAutorizacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpPostAutorizacion", soapRequest);
        OpPostAutorizacionResponse response = OpPostAutorizacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpPostAutorizacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpPreAutorizacionResponse opPreAutorizacion(OpPreAutorizacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opPreAutorizacion");
        if (sentry != null) OpPreAutorizacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(true), sentry);
        SoapObject soapRequest = OpPreAutorizacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpPreAutorizacion", soapRequest, true);
        OpPreAutorizacionResponse response = OpPreAutorizacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpPreAutorizacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(true), sentry);
        return response;
    }

    public Map<String, Object> opPreAutorizacion(Map<String, Object>  request) {
        return OpPreAutorizacionConverter.responsePojoToMap(opPreAutorizacion(OpPreAutorizacionConverter.requestMapToPojo(request)));
    }

    public OpPreCancelacionResponse opPreCancelacion(OpPreCancelacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opPreCancelacion");
        if (sentry != null) OpPreCancelacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpPreCancelacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpPreCancelacion", soapRequest);
        OpPreCancelacionResponse response = OpPreCancelacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpPreCancelacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpReAutorizacionResponse opReAutorizacion(OpReAutorizacionRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opReAutorizacion");
        if (sentry != null) OpReAutorizacionSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpReAutorizacionConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpReAutorizacion", soapRequest);
        OpReAutorizacionResponse response = OpReAutorizacionConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpReAutorizacionSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpReversaResponse opReversa(OpReversaRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opReversa");
        if (sentry != null) OpReversaSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpReversaConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpReversa", soapRequest);
        OpReversaResponse response = OpReversaConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpReversaSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    public OpTransaccionesResponse opTransacciones(OpTransaccionesRequest request) {
        if (sentry != null) sentry.getContext().addTag("qpayclientmethod", "opTransacciones");
        if (sentry != null) OpTransaccionesSentryLogger.logBreadcrumbRequest(request, getQpUrl(false), sentry);
        SoapObject soapRequest = OpTransaccionesConverter.requestPojoToSoapObject(request);
        SoapObject soapResponse = makeSoapCall("OpTransacciones", soapRequest);
        OpTransaccionesResponse response = OpTransaccionesConverter.soapObjectToResponsePojo(soapResponse);
        if (sentry != null) OpTransaccionesSentryLogger.logBreadcrumbResponse(response, getQpUrl(false), sentry);
        return response;
    }

    private SoapObject makeSoapCall(String methodName) {
        return makeSoapCall(methodName, null);
    }

    private SoapObject makeSoapCall(String methodName, SoapObject soapRequest) {
        return makeSoapCall(methodName, soapRequest, false);
    }

    private SoapObject makeSoapCall(String methodName, SoapObject soapRequest, boolean isVgsOperation) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SOAP_ENVELOPE_VERSION);
        new MarshalFloat().register(envelope);
        new MarshalDate().register(envelope);
        new MarshalBase64().register(envelope);
        new MarshalString().register(envelope);
        envelope.headerOut = new Element[1];
        envelope.headerOut[0] = createOpHeader();
        envelope.implicitTypes = true;
        if (soapRequest != null) {
            envelope.setOutputSoapObject(soapRequest);
        }
        HttpTransportSE httpTransportSE = new HttpTransportSE(getQpUrl(isVgsOperation), TIMEOUT);
        httpTransportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        httpTransportSE.setReadTimeout(TIMEOUT);
        try {
            if (debugModeEnabled) {
                httpTransportSE.debug = true;
            }
            String soapAction = NAMESPACE + methodName;
            if(debugModeEnabled) Log.d("Qpay", "Soap Environment:  " + qpAmbiente);
            if(debugModeEnabled) Log.d("Qpay", "Soap Url:  " + getQpUrl(isVgsOperation));
            httpTransportSE.call(soapAction, envelope);
            if (debugModeEnabled) {
                debugRequest = httpTransportSE.requestDump;
                debugResponse = httpTransportSE.responseDump;
                Log.d("Qpay", "Soap Request:  " + httpTransportSE.requestDump);
                Log.d("Qpay", "Soap Response: " + httpTransportSE.responseDump);
            }
            if (envelope.bodyIn instanceof SoapFault) {
                SoapFault soapFault = (SoapFault) envelope.bodyIn;
                throw new QpayClientSoapFaultException(soapFault);
            }
            return (SoapObject) envelope.bodyIn;
        } catch (UnknownHostException e) {
            if(debugModeEnabled) Log.d("Qpay", "Exception: " + e);
            throw new QpayClientConnectionException(e);
        } catch (SocketTimeoutException e) {
            if(debugModeEnabled) Log.d("Qpay", "Exception: " + e);
            throw new QpayClientConnectionLostException(e);
        } catch (SSLException e) {
            if(debugModeEnabled) Log.d("Qpay", "Exception: " + e);
            throw new QpayClientConnectionLostException(e);
        } catch (Exception e) {
            if(debugModeEnabled) Log.d("Qpay", "Exception: " + e);
            throw new QpayClientGeneralException(e);
        }
    }

    private Element createOpHeader() {
        Element OpHeader = new Element().createElement(NAMESPACE, "OpHeader");
        Element OpKey1 = new Element().createElement(NAMESPACE, "OpKey1");
        OpKey1.addChild(Node.TEXT, QPAY_OP_KEY_1);
        OpHeader.addChild(Node.ELEMENT, OpKey1);
        Element OpKey2 = new Element().createElement(NAMESPACE, "OpKey2");
        OpKey2.addChild(Node.TEXT, QPAY_OP_KEY_2);
        OpHeader.addChild(Node.ELEMENT, OpKey2);

        return OpHeader;
    }
}
