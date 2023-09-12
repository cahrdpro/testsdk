package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

class OpFirmaConverter {

    static SoapObject requestPojoToSoapObject(OpFirmaRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpFirma");
        SoapObject cFirmaReq = new SoapObject(NAMESPACE, "cFirmaReq");
        cFirmaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cFirmaReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cFirmaReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cFirmaReq.addProperty(NAMESPACE, "monto", request.monto);
        cFirmaReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cFirmaReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cFirmaReq.addProperty(NAMESPACE, "firma", request.firma);
        cFirmaReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cFirmaReq);
        return soapObject;
    }

    static OpFirmaResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpFirmaResponse response = new OpFirmaResponse();
        SoapObject cFirmaResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cFirmaResp, "comercioId");
        response.transaccionId = SoapObjectUtils.getStringByName(cFirmaResp, "transaccionId");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cFirmaResp, "codigoAprobacion");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cFirmaResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cFirmaResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cFirmaResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cFirmaResp, "ccReturnMsg");
        return response;
    }

}
