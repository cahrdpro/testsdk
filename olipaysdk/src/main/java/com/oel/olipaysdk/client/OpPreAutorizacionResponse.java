package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class OpPreAutorizacionResponse implements OpErrorResponse {

    Integer comercioId;
    String terminalId;
    String transaccionId;
    String fechaTransaccion;
    String horaTransaccion;
    BigDecimal monto;
    String referencia;
    String numeroControl;
    Integer codigoRespuesta;
    String procReturnMsg;
    Integer ccErrorCode;
    String ccReturnMsg;
    String codigoAprobacion;
    String afiliacion;
    String afiliacionEmpresa;
    String emvData;
    String operType;
    String cardType;
    String cardBrand;
    String issuerData;
    String issuingBank;
    String authResult;
    String referredCard;
    String aid;
    String tvr;
    String tsi;
    String apn;
    String al;
    String arqc;

    public Integer getComercioId() {
        return comercioId;
    }

    public void setComercioId(Integer comercioId) {
        this.comercioId = comercioId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public String getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setFechaTransaccion(String fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getHoraTransaccion() {
        return horaTransaccion;
    }

    public void setHoraTransaccion(String horaTransaccion) {
        this.horaTransaccion = horaTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(String numeroControl) {
        this.numeroControl = numeroControl;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public String getProcReturnMsg() {
        return procReturnMsg;
    }

    public void setProcReturnMsg(String procReturnMsg) {
        this.procReturnMsg = procReturnMsg;
    }

    public Integer getCcErrorCode() {
        return ccErrorCode;
    }

    public void setCcErrorCode(Integer ccErrorCode) {
        this.ccErrorCode = ccErrorCode;
    }

    public String getCcReturnMsg() {
        return ccReturnMsg;
    }

    public void setCcReturnMsg(String ccReturnMsg) {
        this.ccReturnMsg = ccReturnMsg;
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    public String getAfiliacionEmpresa() {
        return afiliacionEmpresa;
    }

    public void setAfiliacionEmpresa(String afiliacionEmpresa) {
        this.afiliacionEmpresa = afiliacionEmpresa;
    }

    public String getEmvData() {
        return emvData;
    }

    public void setEmvData(String emvData) {
        this.emvData = emvData;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    public String getIssuerData() {
        return issuerData;
    }

    public void setIssuerData(String issuerData) {
        this.issuerData = issuerData;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public void setIssuingBank(String issuingBank) {
        this.issuingBank = issuingBank;
    }

    public String getAuthResult() {
        return authResult;
    }

    public void setAuthResult(String authResult) {
        this.authResult = authResult;
    }

    public String getReferredCard() {
        return referredCard;
    }

    public void setReferredCard(String referredCard) {
        this.referredCard = referredCard;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getTvr() {
        return tvr;
    }

    public void setTvr(String tvr) {
        this.tvr = tvr;
    }

    public String getTsi() {
        return tsi;
    }

    public void setTsi(String tsi) {
        this.tsi = tsi;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getAl() {
        return al;
    }

    public void setAl(String al) {
        this.al = al;
    }

    public String getArqc() {
        return arqc;
    }

    public void setArqc(String arqc) {
        this.arqc = arqc;
    }

    @Override
    public String toString() {
        return "OpPreAutorizacionResponse{" +
                "comercioId=" + comercioId +
                ", terminalId='" + terminalId + '\'' +
                ", transaccionId='" + transaccionId + '\'' +
                ", fechaTransaccion='" + fechaTransaccion + '\'' +
                ", horaTransaccion='" + horaTransaccion + '\'' +
                ", monto=" + monto +
                ", referencia='" + referencia + '\'' +
                ", numeroControl='" + numeroControl + '\'' +
                ", codigoRespuesta=" + codigoRespuesta +
                ", procReturnMsg='" + procReturnMsg + '\'' +
                ", ccErrorCode=" + ccErrorCode +
                ", ccReturnMsg='" + ccReturnMsg + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", afiliacion='" + afiliacion + '\'' +
                ", afiliacionEmpresa='" + afiliacionEmpresa + '\'' +
                ", emvData='" + emvData + '\'' +
                ", operType='" + operType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", cardBrand='" + cardBrand + '\'' +
                ", issuerData='" + issuerData + '\'' +
                ", issuingBank='" + issuingBank + '\'' +
                ", authResult='" + authResult + '\'' +
                ", referredCard='" + referredCard + '\'' +
                ", aid='" + aid + '\'' +
                ", tvr='" + tvr + '\'' +
                ", tsi='" + tsi + '\'' +
                ", apn='" + apn + '\'' +
                ", al='" + al + '\'' +
                ", arqc='" + arqc + '\'' +
                '}';
    }
}
