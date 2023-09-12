package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

class EnviaVoucherImagenConverter {

    static SoapObject requestPojoToSoapObject(EnviaVoucherImagenRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "enviaVoucherImagen");
        SoapObject cEnviaVoucherImagenReq = new SoapObject(NAMESPACE, "cVoucherReq");
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "modo", request.modo);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "monto", request.monto);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "email", request.email);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cEnviaVoucherImagenReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cEnviaVoucherImagenReq);
        return soapObject;
    }

    static EnviaVoucherImagenResponse soapObjectToResponsePojo(SoapObject soapObject) {
        EnviaVoucherImagenResponse response = new EnviaVoucherImagenResponse();
        SoapObject cVoucherResp = (SoapObject) soapObject.getProperty(0);
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cVoucherResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cVoucherResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cVoucherResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cVoucherResp, "ccReturnMsg");
        return response;
    }

}
