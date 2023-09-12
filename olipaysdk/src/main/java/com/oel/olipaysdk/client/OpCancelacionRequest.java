package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class OpCancelacionRequest {

    Integer comercioId;
    String contrasena;
    String modo;
    BigDecimal monto;
    String transaccionId;
    String codigoAprobacion;
    String referenciaBanco;
    String firma;
    String dirIp;
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

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(String transaccionId) {
        this.transaccionId = transaccionId;
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

    public String getDirIp() {
        return dirIp;
    }

    public void setDirIp(String dirIp) {
        this.dirIp = dirIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OpCancelacionRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", modo='" + modo + '\'' +
                ", monto=" + monto +
                ", transaccionId='" + transaccionId + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", referenciaBanco='" + referenciaBanco + '\'' +
                ", firma=" + firma +
                ", dirIp='" + dirIp + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

}
