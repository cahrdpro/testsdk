package com.oel.olipaysdk.client;

public class OpFirmaResponse implements OpErrorResponse {

    Integer comercioId;
    String transaccionId;
    String codigoAprobacion;
    Integer codigoRespuesta;
    String procReturnMsg;
    Integer ccErrorCode;
    String ccReturnMsg;

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
        return "OpFirmaResponse{" +
                "comercioId=" + comercioId +
                ", transaccionId='" + transaccionId + '\'' +
                ", codigoRespuesta=" + codigoRespuesta +
                ", procReturnMsg='" + procReturnMsg + '\'' +
                ", ccErrorCode=" + ccErrorCode +
                ", ccReturnMsg='" + ccReturnMsg + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                '}';
    }


}
