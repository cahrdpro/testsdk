package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

class RecurrentesCargoConverter {

    static SoapObject requestPojoToSoapObject(RecurrentesCargoRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "recurrentesCargo");
        SoapObject cVentaReq = new SoapObject(NAMESPACE, "cVentaReq");
        cVentaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cVentaReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cVentaReq.addProperty(NAMESPACE, "modo", request.modo);
        cVentaReq.addProperty(NAMESPACE, "monto", request.monto);
        cVentaReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cVentaReq.addProperty(NAMESPACE, "referencia", request.referencia);
        cVentaReq.addProperty(NAMESPACE, "tarjeta", request.tarjeta);
        cVentaReq.addProperty(NAMESPACE, "tipo", request.tipo);
        cVentaReq.addProperty(NAMESPACE, "mes", request.mes);
        cVentaReq.addProperty(NAMESPACE, "anio", request.anio);
        cVentaReq.addProperty(NAMESPACE, "digitos", request.digitos);
        cVentaReq.addProperty(NAMESPACE, "titular", request.titular);
        cVentaReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cVentaReq.addProperty(NAMESPACE, "posEntryMode", request.posEntryMode);
        cVentaReq.addProperty(NAMESPACE, "track2", request.track2);
        cVentaReq.addProperty(NAMESPACE, "emvTags", request.emvTags);
        cVentaReq.addProperty(NAMESPACE, "diferimiento", request.diferimiento);
        cVentaReq.addProperty(NAMESPACE, "numeroPagos", request.numeroPagos);
        cVentaReq.addProperty(NAMESPACE, "plan", request.plan);
        cVentaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cVentaReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cVentaReq);
        return soapObject;
    }

    static RecurrentesCargoResponse soapObjectToResponsePojo(SoapObject soapObject) {
        RecurrentesCargoResponse response = new RecurrentesCargoResponse();
        SoapObject cVentaResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cVentaResp, "comercioId");
        response.transaccionId = SoapObjectUtils.getStringByName(cVentaResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cVentaResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cVentaResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cVentaResp, "monto");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cVentaResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cVentaResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cVentaResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cVentaResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cVentaResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cVentaResp, "afiliacion");
        response.emvData = SoapObjectUtils.getStringByName(cVentaResp, "emvData");
        response.operType = SoapObjectUtils.getStringByName(cVentaResp, "operType");
        response.cardType = SoapObjectUtils.getStringByName(cVentaResp, "cardType");
        response.issuerData = SoapObjectUtils.getStringByName(cVentaResp, "issuerData");
        response.issuingBank = SoapObjectUtils.getStringByName(cVentaResp, "issuingBank");
        return response;
    }

}
