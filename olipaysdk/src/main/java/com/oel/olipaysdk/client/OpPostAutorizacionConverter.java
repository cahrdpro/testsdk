package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpPostAutorizacionConverter {

    static SoapObject requestPojoToSoapObject(OpPostAutorizacionRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpPostAutorizacion");
        SoapObject cPostAutorizacionReq = new SoapObject(NAMESPACE, "cPostAutorizacionReq");
        cPostAutorizacionReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cPostAutorizacionReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cPostAutorizacionReq.addProperty(NAMESPACE, "modo", request.modo);
        cPostAutorizacionReq.addProperty(NAMESPACE, "monto", request.monto);
        cPostAutorizacionReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cPostAutorizacionReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cPostAutorizacionReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cPostAutorizacionReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cPostAutorizacionReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cPostAutorizacionReq);
        return soapObject;
    }

    static OpPostAutorizacionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpPostAutorizacionResponse response = new OpPostAutorizacionResponse();
        SoapObject cPostAutorizacionResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cPostAutorizacionResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cPostAutorizacionResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "referencia");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cPostAutorizacionResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cPostAutorizacionResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cPostAutorizacionResp, "afiliacionEmpresa");
        return response;
    }

}
