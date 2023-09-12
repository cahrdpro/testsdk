package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class RecurrentesCargoResponse implements OpErrorResponse {

    Integer comercioId;
    String transaccionId;
    String fechaTransaccion;
    String horaTransaccion;
    BigDecimal monto;
    Integer codigoRespuesta;
    String procReturnMsg;
    Integer ccErrorCode;
    String ccReturnMsg;
    String codigoAprobacion;
    String afiliacion;
    String emvData;
    String operType;
    String cardType;
    String issuerData;
    String issuingBank;

    public Integer getComercioId() {
        return comercioId;
    }

    public void setComercioId(Integer comercioId) {
        this.comercioId = comercioId;
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

    @Override
    public String toString() {
        return "RecurrentesCargoResponse{" +
                "comercioId=" + comercioId +
                ", transaccionId='" + transaccionId + '\'' +
                ", fechaTransaccion='" + fechaTransaccion + '\'' +
                ", horaTransaccion='" + horaTransaccion + '\'' +
                ", monto=" + monto +
                ", codigoRespuesta=" + codigoRespuesta +
                ", procReturnMsg='" + procReturnMsg + '\'' +
                ", ccErrorCode=" + ccErrorCode +
                ", ccReturnMsg='" + ccReturnMsg + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", afiliacion='" + afiliacion + '\'' +
                ", emvData='" + emvData + '\'' +
                ", operType='" + operType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", issuerData='" + issuerData + '\'' +
                ", issuingBank='" + issuingBank + '\'' +
                '}';
    }

}