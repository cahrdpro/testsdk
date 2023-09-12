package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpReAutorizacionConverter {

    static SoapObject requestPojoToSoapObject(OpReAutorizacionRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpReAutorizacion");
        SoapObject cReAutorizacionReq = new SoapObject(NAMESPACE, "cReAutorizacionReq");
        cReAutorizacionReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cReAutorizacionReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cReAutorizacionReq.addProperty(NAMESPACE, "modo", request.modo);
        cReAutorizacionReq.addProperty(NAMESPACE, "monto", request.monto);
        cReAutorizacionReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cReAutorizacionReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cReAutorizacionReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cReAutorizacionReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cReAutorizacionReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cReAutorizacionReq);
        return soapObject;
    }

    static OpReAutorizacionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpReAutorizacionResponse response = new OpReAutorizacionResponse();
        SoapObject cReAutorizacionResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cReAutorizacionResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cReAutorizacionResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cReAutorizacionResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cReAutorizacionResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cReAutorizacionResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cReAutorizacionResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cReAutorizacionResp, "referencia");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cReAutorizacionResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cReAutorizacionResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cReAutorizacionResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cReAutorizacionResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cReAutorizacionResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cReAutorizacionResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cReAutorizacionResp, "afiliacionEmpresa");
        return response;
    }

}
