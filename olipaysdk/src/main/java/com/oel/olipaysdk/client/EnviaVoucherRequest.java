package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class EnviaVoucherRequest {

    Integer comercioId;
    String contrasena;
    String modo;
    BigDecimal monto;
    String transaccionId;
    String codigoAprobacion;
    String referenciaBanco;
    String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "EnviaVoucherRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", email='" + email + '\'' +
                ", modo='" + modo + '\'' +
                ", monto=" + monto +
                ", transaccionId='" + transaccionId + '\'' +
                ", codigoAprobacion='" + codigoAprobacion + '\'' +
                ", referenciaBanco='" + referenciaBanco + '\'' +
                ", dirIp='" + dirIp + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

}
