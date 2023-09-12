package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpPreCancelacionConverter {

    static SoapObject requestPojoToSoapObject(OpPreCancelacionRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpPreCancelacion");
        SoapObject cCancelacionReq = new SoapObject(NAMESPACE, "cCancelacionReq");
        cCancelacionReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cCancelacionReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cCancelacionReq.addProperty(NAMESPACE, "modo", request.modo);
        cCancelacionReq.addProperty(NAMESPACE, "monto", request.monto);
        cCancelacionReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cCancelacionReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cCancelacionReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cCancelacionReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cCancelacionReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cCancelacionReq);
        return soapObject;
    }

    static OpPreCancelacionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpPreCancelacionResponse response = new OpPreCancelacionResponse();
        SoapObject cCancelacionResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cCancelacionResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cCancelacionResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cCancelacionResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cCancelacionResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cCancelacionResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cCancelacionResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cCancelacionResp, "referencia");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cCancelacionResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cCancelacionResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cCancelacionResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cCancelacionResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cCancelacionResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cCancelacionResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cCancelacionResp, "afiliacionEmpresa");
        return response;
    }

}
