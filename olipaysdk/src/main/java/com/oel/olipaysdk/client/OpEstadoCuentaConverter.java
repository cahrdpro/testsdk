package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class OpEstadoCuentaConverter {

    static SoapObject requestPojoToSoapObject(OpEstadoCuentaRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpEstadoCuenta");
        SoapObject cEstadoCuentaReq = new SoapObject(NAMESPACE, "cEstadoCuentaReq");
        cEstadoCuentaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cEstadoCuentaReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cEstadoCuentaReq.addProperty(NAMESPACE, "periodo", request.periodo);
        cEstadoCuentaReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cEstadoCuentaReq);
        return soapObject;
    }

    static OpEstadoCuentaResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpEstadoCuentaResponse response = new OpEstadoCuentaResponse();
        return response;
    }

}
