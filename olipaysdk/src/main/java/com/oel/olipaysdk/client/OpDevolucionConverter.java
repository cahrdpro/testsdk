package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpDevolucionConverter {

    static SoapObject requestPojoToSoapObject(OpDevolucionRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpDevolucion");
        SoapObject cDevolucionReq = new SoapObject(NAMESPACE, "cDevolucionReq");
        cDevolucionReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cDevolucionReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cDevolucionReq.addProperty(NAMESPACE, "modo", request.modo);
        cDevolucionReq.addProperty(NAMESPACE, "monto", request.monto);
        cDevolucionReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cDevolucionReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cDevolucionReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cDevolucionReq.addProperty(NAMESPACE, "firma", request.firma);
        cDevolucionReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cDevolucionReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cDevolucionReq);
        return soapObject;
    }

    static OpDevolucionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpDevolucionResponse response = new OpDevolucionResponse();
        SoapObject cDevolucionResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cDevolucionResp, "comercioId");
        response.transaccionId = SoapObjectUtils.getStringByName(cDevolucionResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cDevolucionResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cDevolucionResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cDevolucionResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cDevolucionResp, "referencia");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cDevolucionResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cDevolucionResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cDevolucionResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cDevolucionResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cDevolucionResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cDevolucionResp, "afiliacion");
        return response;
    }

}
