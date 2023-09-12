package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

public class EcommerceVentaConverter {

    static SoapObject requestPojoToSoapObject(EcommerceVentaRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "ecommerceVenta");
        SoapObject cTCReq = new SoapObject(NAMESPACE, "cTCReq");
        cTCReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cTCReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cTCReq.addProperty(NAMESPACE, "modo", request.modo);
        cTCReq.addProperty(NAMESPACE, "monto", request.monto);
        cTCReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cTCReq.addProperty(NAMESPACE, "referencia", request.referencia);
        cTCReq.addProperty(NAMESPACE, "tarjeta", request.tarjeta);
        cTCReq.addProperty(NAMESPACE, "tipo", request.tipo);
        cTCReq.addProperty(NAMESPACE, "mes", request.mes);
        cTCReq.addProperty(NAMESPACE, "anio", request.anio);
        cTCReq.addProperty(NAMESPACE, "digitos", request.digitos);
        cTCReq.addProperty(NAMESPACE, "titular", request.titular);
        cTCReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cTCReq.addProperty(NAMESPACE, "diferimiento", request.diferimiento);
        cTCReq.addProperty(NAMESPACE, "numeroPagos", request.numeroPagos);
        cTCReq.addProperty(NAMESPACE, "plan", request.plan);
        cTCReq.addProperty(NAMESPACE, "xid", request.xid);
        cTCReq.addProperty(NAMESPACE, "cavv", request.cavv);
        cTCReq.addProperty(NAMESPACE, "eci", request.eci);
        cTCReq.addProperty(NAMESPACE, "status_3d", request.status_3d);
        soapObject.addProperty(NAMESPACE, "request", cTCReq);
        return soapObject;
    }

    static EcommerceVentaResponse soapObjectToResponsePojo(SoapObject soapObject) {
        EcommerceVentaResponse response = new EcommerceVentaResponse();
        SoapObject cTCResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cTCResp, "comercioId");
        response.transaccionId = SoapObjectUtils.getStringByName(cTCResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cTCResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cTCResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cTCResp, "monto");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cTCResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cTCResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cTCResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cTCResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cTCResp, "codigoAprobacion");
        return response;
    }

}