package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class EcommerceVentaResponse implements OpErrorResponse {

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

    @Override
    public String toString() {
        return "EcommerceVentaResponse{" +
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
                '}';
    }

}