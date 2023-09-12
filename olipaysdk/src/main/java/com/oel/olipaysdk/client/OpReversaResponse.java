package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class OpReversaResponse implements OpErrorResponse {

    Integer comercioId;
    String terminalId;
    String transaccionId;
    String fechaTransaccion;
    String horaTransaccion;
    BigDecimal monto;
    String referencia;
    Integer codigoRespuesta;
    String procReturnMsg;
    Integer ccErrorCode;
    String ccReturnMsg;
    String codigoAprobacion;
    String afiliacion;
    String afiliacionEmpresa;

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

    @Override
    public String toString() {
        return "OpReversaResponse{" +
                "comercioId=" + comercioId +
                ", terminalId='" + terminalId + '\'' +
                ", transaccionId='" + transaccionId + '\'' +
                ", fechaTransaccion='" + fechaTransaccion + '\'' +
                ", horaTransaccion='" + horaTransaccion + '\'' +
                ", monto=" + monto +
                ", referencia='" + referencia + '\'' +
                ", codigoRespuesta=" + codigoRespuesta +
                ", procReturnMsg='" + procReturnMsg + '\'' +
                ", ccErrorCode=" + ccErrorCode +
                ", ccReturnMsg='" + ccReturnMsg + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", afiliacion='" + afiliacion + '\'' +
                ", afiliacionEmpresa='" + afiliacionEmpresa + '\'' +
                '}';
    }

}