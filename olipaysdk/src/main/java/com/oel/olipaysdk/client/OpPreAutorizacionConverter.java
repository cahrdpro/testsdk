package com.oel.olipaysdk.client;

import static com.oel.olipaysdk.client.QpayClient.NAMESPACE;

import org.ksoap2.serialization.SoapObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

class OpPreAutorizacionConverter {

    static SoapObject requestPojoToSoapObject(OpPreAutorizacionRequest request) {
        SoapObject soapObject = new SoapObject(NAMESPACE, "OpPreAutorizacion");
        SoapObject cPreAutorizacionReq = new SoapObject(NAMESPACE, "cPreAutorizacionReq");
        cPreAutorizacionReq.addProperty(NAMESPACE, "comercioId", request.comercioId);
        cPreAutorizacionReq.addProperty(NAMESPACE, "contrasena", request.contrasena);
        cPreAutorizacionReq.addProperty(NAMESPACE, "modo", request.modo);
        cPreAutorizacionReq.addProperty(NAMESPACE, "monto", request.monto);
        cPreAutorizacionReq.addProperty(NAMESPACE, "transaccionId", request.transaccionId);
        cPreAutorizacionReq.addProperty(NAMESPACE, "referencia", request.referencia);
        cPreAutorizacionReq.addProperty(NAMESPACE, "tarjeta", request.tarjeta);
        cPreAutorizacionReq.addProperty(NAMESPACE, "tipo", request.tipo);
        cPreAutorizacionReq.addProperty(NAMESPACE, "mes", request.mes);
        cPreAutorizacionReq.addProperty(NAMESPACE, "anio", request.anio);
        cPreAutorizacionReq.addProperty(NAMESPACE, "digitos", request.digitos);
        cPreAutorizacionReq.addProperty(NAMESPACE, "titular", request.titular);
        cPreAutorizacionReq.addProperty(NAMESPACE, "dirIp", request.dirIp);
        cPreAutorizacionReq.addProperty(NAMESPACE, "posEntryMode", request.posEntryMode);
        cPreAutorizacionReq.addProperty(NAMESPACE, "track2", request.track2);
        cPreAutorizacionReq.addProperty(NAMESPACE, "emvTags", request.emvTags);
        cPreAutorizacionReq.addProperty(NAMESPACE, "aid", request.aid);
        cPreAutorizacionReq.addProperty(NAMESPACE, "tvr", request.tvr);
        cPreAutorizacionReq.addProperty(NAMESPACE, "tsi", request.tsi);
        cPreAutorizacionReq.addProperty(NAMESPACE, "apn", request.apn);
        cPreAutorizacionReq.addProperty(NAMESPACE, "al", request.al != null ? request.al.replaceAll("\\p{Cc}", "") : null); // Replace \u0000, \u0007 \u0011, \u0012, \u0013 and similar control characters with empty string since soap client throws IllegalCharacterException
        cPreAutorizacionReq.addProperty(NAMESPACE, "arqc", request.arqc);
        cPreAutorizacionReq.addProperty(NAMESPACE, "deviceId", request.deviceId);
        cPreAutorizacionReq.addProperty(NAMESPACE, "version", request.version);
        soapObject.addProperty(NAMESPACE, "request", cPreAutorizacionReq);
        return soapObject;
    }

    static OpPreAutorizacionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpPreAutorizacionResponse response = new OpPreAutorizacionResponse();
        SoapObject cPreAutorizacionResp = (SoapObject) soapObject.getProperty(0);
        response.comercioId = SoapObjectUtils.getIntegerByName(cPreAutorizacionResp, "comercioId");
        response.terminalId = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "terminalId");
        response.transaccionId = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "transaccionId");
        response.fechaTransaccion = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "fechaTransaccion");
        response.horaTransaccion = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "horaTransaccion");
        response.monto = SoapObjectUtils.getBigDecimalByName(cPreAutorizacionResp, "monto");
        response.referencia = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "referencia");
        response.numeroControl = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "numeroControl");
        response.codigoRespuesta = SoapObjectUtils.getIntegerByName(cPreAutorizacionResp, "codigoRespuesta");
        response.procReturnMsg = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "procReturnMsg");
        response.ccErrorCode = SoapObjectUtils.getIntegerByName(cPreAutorizacionResp, "ccErrorCode");
        response.ccReturnMsg = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "ccReturnMsg");
        response.codigoAprobacion = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "codigoAprobacion");
        response.afiliacion = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "afiliacion");
        response.afiliacionEmpresa = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "afiliacionEmpresa");
        response.emvData = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "emvData");
        response.operType = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "operType");
        response.cardType = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "cardType");
        response.cardBrand = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "cardBrand");
        response.issuerData = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "issuerData");
        response.issuingBank = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "issuingBank");
        response.authResult = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "auth_result");
        response.referredCard = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "referred_card");
        response.aid = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "aid");
        response.tvr = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "tvr");
        response.tsi = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "tsi");
        response.apn = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "apn");
        response.al = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "al");
        response.arqc = SoapObjectUtils.getStringByName(cPreAutorizacionResp, "arqc");
        return response;
    }

    public static OpPreAutorizacionRequest requestMapToPojo(Map request) {
        OpPreAutorizacionRequest opPreAutorizacionRequest = new OpPreAutorizacionRequest();
        opPreAutorizacionRequest.comercioId = (Integer) request.get("comercioId");
        opPreAutorizacionRequest.contrasena = (String) request.get("contrasena");
        opPreAutorizacionRequest.modo = (String) request.get("modo");
        opPreAutorizacionRequest.monto = (BigDecimal) request.get("monto");
        opPreAutorizacionRequest.transaccionId = (String) request.get("transaccionId");
        opPreAutorizacionRequest.referencia = (String) request.get("referencia");
        opPreAutorizacionRequest.tarjeta = (String) request.get("tarjeta");
        opPreAutorizacionRequest.tipo = (String) request.get("tipo");
        opPreAutorizacionRequest.mes = (String) request.get("mes");
        opPreAutorizacionRequest.anio = (String) request.get("anio");
        opPreAutorizacionRequest.digitos = (String) request.get("digitos");
        opPreAutorizacionRequest.titular = (String) request.get("titular");
        opPreAutorizacionRequest.dirIp = (String) request.get("dirIp");
        opPreAutorizacionRequest.posEntryMode = (String) request.get("posEntryMode");
        opPreAutorizacionRequest.track2 = (String) request.get("track2");
        opPreAutorizacionRequest.emvTags = (String) request.get("emvTags");
        opPreAutorizacionRequest.aid = (String) request.get("aid");
        opPreAutorizacionRequest.tvr = (String) request.get("tvr");
        opPreAutorizacionRequest.tsi = (String) request.get("tsi");
        opPreAutorizacionRequest.apn = (String) request.get("apn");
        opPreAutorizacionRequest.al = request.get("al") != null ? ((String) request.get("al")).replaceAll("\\p{Cc}", "") : null; // Replace \u0000, \u0007 \u0011, \u0012, \u0013 and similar control characters with empty string since soap client throws IllegalCharacterException        opPreAutorizacionRequest.arqc = (String) request.get("arqc");
        opPreAutorizacionRequest.deviceId = (String) request.get("deviceId");
        opPreAutorizacionRequest.version = (String) request.get("version");
        return opPreAutorizacionRequest;
    }

    public static Map<String, Object> responsePojoToMap(OpPreAutorizacionResponse opPreAutorizacionResponse) {
        Map<String, Object> response = new HashMap<>();
        response.put("comercioId", opPreAutorizacionResponse.getComercioId());
        response.put("terminalId", opPreAutorizacionResponse.getTerminalId());
        response.put("transaccionId", opPreAutorizacionResponse.getTransaccionId());
        response.put("fechaTransaccion", opPreAutorizacionResponse.getFechaTransaccion());
        response.put("horaTransaccion", opPreAutorizacionResponse.getHoraTransaccion());
        response.put("monto", opPreAutorizacionResponse.getMonto());
        response.put("referencia", opPreAutorizacionResponse.getReferencia());
        response.put("numeroControl", opPreAutorizacionResponse.getNumeroControl());
        response.put("codigoRespuesta", opPreAutorizacionResponse.getCodigoRespuesta());
        response.put("procReturnMsg", opPreAutorizacionResponse.getProcReturnMsg());
        response.put("ccErrorCode", opPreAutorizacionResponse.getCcErrorCode());
        response.put("ccReturnMsg", opPreAutorizacionResponse.getCcReturnMsg());
        response.put("codigoAprobacion", opPreAutorizacionResponse.getCodigoAprobacion());
        response.put("afiliacion", opPreAutorizacionResponse.getAfiliacion());
        response.put("afiliacionEmpresa", opPreAutorizacionResponse.getAfiliacionEmpresa());
        response.put("emvData", opPreAutorizacionResponse.getEmvData());
        response.put("operType", opPreAutorizacionResponse.getOperType());
        response.put("cardType", opPreAutorizacionResponse.getCardType());
        response.put("cardBrand", opPreAutorizacionResponse.getCardBrand());
        response.put("issuerData", opPreAutorizacionResponse.getIssuerData());
        response.put("issuingBank", opPreAutorizacionResponse.getIssuingBank());
        response.put("authResult", opPreAutorizacionResponse.getAuthResult());
        response.put("referredCard", opPreAutorizacionResponse.getReferredCard());
        response.put("AID", opPreAutorizacionResponse.getAid());
        response.put("TVR", opPreAutorizacionResponse.getTvr());
        response.put("TSI", opPreAutorizacionResponse.getTsi());
        response.put("APN", opPreAutorizacionResponse.getApn());
        response.put("AL", opPreAutorizacionResponse.getAl());
        response.put("ARQC", opPreAutorizacionResponse.getArqc());
        return response;
    }

}
