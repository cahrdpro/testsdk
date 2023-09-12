package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpReversaConverter {

    static SoapObject requestPojoToSoapObject(OpReversaRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpReversa");
        SoapObject cReversaReq = new SoapObject(NAMESPACE, "cReversaReq");
        cReversaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cReversaReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cReversaReq.addProperty(NAMESPACE, "modo", request.modo);
        cReversaReq.addProperty(NAMESPACE, "monto", request.monto);
        cReversaReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cReversaReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cReversaReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cReversaReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cReversaReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cReversaReq);
        return soapObject;
    }

    static OpReversaResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpReversaResponse response = new OpReversaResponse();
        SoapObject cReversaResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cReversaResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cReversaResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cReversaResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cReversaResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cReversaResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cReversaResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cReversaResp, "referencia");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cReversaResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cReversaResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cReversaResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cReversaResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cReversaResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cReversaResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cReversaResp, "afiliacionEmpresa");
        return response;
    }

}
