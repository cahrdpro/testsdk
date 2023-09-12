package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class OpVentaConverter {

    static SoapObject requestPojoToSoapObject(OpVentaRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpVenta");
        SoapObject cVentaReq = new SoapObject(NAMESPACE, "cVentaReq");
        cVentaReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cVentaReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cVentaReq.addProperty(NAMESPACE, "modo", request.modo);
        cVentaReq.addProperty(NAMESPACE, "monto", request.monto);
        cVentaReq.addProperty(NAMESPACE, "propina", request.propina);
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
        cVentaReq.addProperty(NAMESPACE, "aid", request.aid);
        cVentaReq.addProperty(NAMESPACE, "tvr", request.tvr);
        cVentaReq.addProperty(NAMESPACE, "tsi", request.tsi);
        cVentaReq.addProperty(NAMESPACE, "apn", request.apn);
        cVentaReq.addProperty(NAMESPACE, "al", request.al != null ? request.al.replaceAll("\\p{Cc}", "") : null); // Replace \u0000, \u0007 \u0011, \u0012, \u0013 and similar control characters with empty string since soap client throws IllegalCharacterException
        cVentaReq.addProperty(NAMESPACE, "arqc", request.arqc);
        cVentaReq.addProperty(NAMESPACE, "diferimiento", request.diferimiento);
        cVentaReq.addProperty(NAMESPACE, "numeroPagos", request.numeroPagos);
        cVentaReq.addProperty(NAMESPACE, "plan", request.plan);
        cVentaReq.addProperty(NAMESPACE, "qps", request.qps);
        cVentaReq.addProperty(NAMESPACE, "deviceId", request.deviceId);
        cVentaReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cVentaReq);
        return soapObject;
    }

    static OpVentaResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpVentaResponse response = new OpVentaResponse();
        SoapObject cVentaResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cVentaResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cVentaResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cVentaResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cVentaResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cVentaResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cVentaResp, "monto");
        response.propina = SoapObjectUtils.getBigDecimalByName(cVentaResp, "propina");
        response.referencia = SoapObjectUtils.getStringByName(cVentaResp, "referencia");
        response.numeroControl = SoapObjectUtils.getStringByName(cVentaResp, "numeroControl");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cVentaResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cVentaResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cVentaResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cVentaResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cVentaResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cVentaResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cVentaResp, "afiliacionEmpresa");
        response.emvData = SoapObjectUtils.getStringByName(cVentaResp, "emvData");
        response.operType = SoapObjectUtils.getStringByName(cVentaResp, "operType");
        response.cardType = SoapObjectUtils.getStringByName(cVentaResp, "cardType");
        response.cardBrand = SoapObjectUtils.getStringByName(cVentaResp, "cardBrand");
        response.issuerData = SoapObjectUtils.getStringByName(cVentaResp, "issuerData");
        response.issuingBank = SoapObjectUtils.getStringByName(cVentaResp, "issuingBank");
        response.authResult = SoapObjectUtils.getStringByName(cVentaResp, "auth_result");
        response.referredCard = SoapObjectUtils.getStringByName(cVentaResp, "referred_card");
        response.aid = SoapObjectUtils.getStringByName(cVentaResp, "aid");
        response.tvr = SoapObjectUtils.getStringByName(cVentaResp, "tvr");
        response.tsi = SoapObjectUtils.getStringByName(cVentaResp, "tsi");
        response.apn = SoapObjectUtils.getStringByName(cVentaResp, "apn");
        response.al = SoapObjectUtils.getStringByName(cVentaResp, "al");
        response.arqc = SoapObjectUtils.getStringByName(cVentaResp, "arqc");
        return response;
    }

    public static OpVentaRequest requestMapToPojo(Map request) {
        OpVentaRequest opVentaRequest = new OpVentaRequest();
        opVentaRequest.comercioId = (Integer) request.get("comercioId");
        opVentaRequest.contrasena = (String) request.get("contrasena");
        opVentaRequest.modo = (String) request.get("modo");
        opVentaRequest.monto = (BigDecimal) request.get("monto");
        opVentaRequest.propina = (BigDecimal) request.get("propina");
        opVentaRequest.transaccionId = (String) request.get("transaccionId");
        opVentaRequest.referencia = (String) request.get("referencia");
        opVentaRequest.tarjeta = (String) request.get("tarjeta");
        opVentaRequest.tipo = (String) request.get("tipo");
        opVentaRequest.mes = (String) request.get("mes");
        opVentaRequest.anio = (String) request.get("anio");
        opVentaRequest.digitos = (String) request.get("digitos");
        opVentaRequest.titular = (String) request.get("titular");
        opVentaRequest.dirIp = (String) request.get("dirIp");
        opVentaRequest.posEntryMode = (String) request.get("posEntryMode");
        opVentaRequest.track2 = (String) request.get("track2");
        opVentaRequest.emvTags = (String) request.get("emvTags");
        opVentaRequest.aid = (String) request.get("aid");
        opVentaRequest.tvr = (String) request.get("tvr");
        opVentaRequest.tsi = (String) request.get("tsi");
        opVentaRequest.apn = (String) request.get("apn");
        opVentaRequest.al = request.get("al") != null ? ((String) request.get("al")).replaceAll("\\p{Cc}", "") : null; // Replace \u0000, \u0007 \u0011, \u0012, \u0013 and similar control characters with empty string since soap client throws IllegalCharacterException
        opVentaRequest.arqc = (String) request.get("arqc");
        opVentaRequest.diferimiento = (String) request.get("diferimiento");
        opVentaRequest.numeroPagos = (String) request.get("numeroPagos");
        opVentaRequest.plan = (String) request.get("plan");
        opVentaRequest.qps = (String) request.get("qps");
        opVentaRequest.deviceId = (String) request.get("deviceId");
        opVentaRequest.version = (String) request.get("version");
        return opVentaRequest;
    }

    public static Map<String, Object> responsePojoToMap(OpVentaResponse opVentaResponse) {
        Map<String, Object> response = new HashMap<>();
        response.put("comercioId", opVentaResponse.getComercioId());
        response.put("terminalId", opVentaResponse.getTerminalId());
        response.put("transaccionId", opVentaResponse.getTransaccionId());
        response.put("fechaTransaccion", opVentaResponse.getFechaTransaccion());
        response.put("horaTransaccion", opVentaResponse.getHoraTransaccion());
        response.put("monto", opVentaResponse.getMonto());
        response.put("propina", opVentaResponse.getPropina());
        response.put("referencia", opVentaResponse.getReferencia());
        response.put("numeroControl", opVentaResponse.getNumeroControl());
        response.put("codigoRespuesta", opVentaResponse.getCodigoRespuesta());
        response.put("procReturnMsg", opVentaResponse.getProcReturnMsg());
        response.put("ccErrorCode", opVentaResponse.getCcErrorCode());
        response.put("ccReturnMsg", opVentaResponse.getCcReturnMsg());
        response.put("codigoAprobacion", opVentaResponse.getCodigoAprobacion());
        response.put("afiliacion", opVentaResponse.getAfiliacion());
        response.put("afiliacionEmpresa", opVentaResponse.getAfiliacionEmpresa());
        response.put("emvData", opVentaResponse.getEmvData());
        response.put("operType", opVentaResponse.getOperType());
        response.put("cardType", opVentaResponse.getCardType());
        response.put("cardBrand", opVentaResponse.getCardBrand());
        response.put("issuerData", opVentaResponse.getIssuerData());
        response.put("issuingBank", opVentaResponse.getIssuingBank());
        response.put("authResult", opVentaResponse.getAuthResult());
        response.put("referredCard", opVentaResponse.getReferredCard());
        response.put("AID", opVentaResponse.getAid());
        response.put("TVR", opVentaResponse.getTvr());
        response.put("TSI", opVentaResponse.getTsi());
        response.put("APN", opVentaResponse.getApn());
        response.put("AL", opVentaResponse.getAl());
        response.put("ARQC", opVentaResponse.getArqc());
        return response;
    }
}
