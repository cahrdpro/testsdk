package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

class EnviaVoucherConverter {

    static SoapObject requestPojoToSoapObject(EnviaVoucherRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "enviaVoucher");
        SoapObject cEnviaVoucherReq = new SoapObject(NAMESPACE, "cVoucherReq");
        cEnviaVoucherReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cEnviaVoucherReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cEnviaVoucherReq.addProperty(NAMESPACE, "modo", request.modo);
        cEnviaVoucherReq.addProperty(NAMESPACE, "monto", request.monto);
        cEnviaVoucherReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cEnviaVoucherReq.addProperty(NAMESPACE, "codigoAprobacion", request.codigoAprobacion);
        cEnviaVoucherReq.addProperty(NAMESPACE, "referencia", request.referenciaBanco);
        cEnviaVoucherReq.addProperty(NAMESPACE, "email", request.email);
        cEnviaVoucherReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cEnviaVoucherReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cEnviaVoucherReq);
        return soapObject;
    }

    static EnviaVoucherResponse soapObjectToResponsePojo(SoapObject soapObject) {
        EnviaVoucherResponse response = new EnviaVoucherResponse();
        SoapObject cVoucherResp = (SoapObject) soapObject.getProperty(0);
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cVoucherResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cVoucherResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cVoucherResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cVoucherResp, "ccReturnMsg");
        return response;
    }

}
