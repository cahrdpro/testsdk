package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class OpFirmaRequest {

    Integer comercioId;
    String contrasena;
    String transaccionId;
    BigDecimal monto;
    String codigoAprobacion;
    String referenciaBanco;
    String firma;
    String version;

    public Integer getComercioId() {
        return comercioId;
    }

    public void setComercioId(Integer comercioId) {
        this.comercioId = comercioId;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public String getReferenciaBanco() {
        return referenciaBanco;
    }

    public void setReferenciaBanco(String referenciaBanco) {
        this.referenciaBanco = referenciaBanco;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OpFirmaRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", transaccionId='" + transaccionId + '\'' +
                ", monto=" + monto +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", referenciaBanco='" + referenciaBanco + '\'' +
                ", firma=" + firma +
                ", version='" + version + '\'' +
                '}';
    }
}
