package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class EcommerceVentaRequest {

    Integer comercioId;
    String contrasena;
    String modo;
    BigDecimal monto;
    String transaccionId;
    String referencia;
    String tarjeta;
    String tipo;
    String mes;
    String anio;
    String digitos;
    String titular;
    String dirIp;
    String diferimiento;
    String numeroPagos;
    String plan;
    String xid;
    String cavv;
    String eci;
    String status_3d;

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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDigitos() {
        return digitos;
    }

    public void setDigitos(String digitos) {
        this.digitos = digitos;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDirIp() {
        return dirIp;
    }

    public void setDirIp(String dirIp) {
        this.dirIp = dirIp;
    }

    public String getDiferimiento() {
        return diferimiento;
    }

    public void setDiferimiento(String diferimiento) {
        this.diferimiento = diferimiento;
    }

    public String getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(String numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getStatus_3d() {
        return status_3d;
    }

    public void setStatus_3d(String status_3d) {
        this.status_3d = status_3d;
    }

    @Override
    public String toString() {
        return "EcommerceVentaRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", modo='" + modo + '\'' +
                ", monto=" + monto +
                ", transaccionId='" + transaccionId + '\'' +
                ", referencia='" + referencia + '\'' +
                ", tarjeta='" + tarjeta + '\'' +
                ", tipo='" + tipo + '\'' +
                ", mes='" + mes + '\'' +
                ", anio='" + anio + '\'' +
                ", digitos='" + digitos + '\'' +
                ", titular='" + titular + '\'' +
                ", dirIp='" + dirIp + '\'' +
                ", diferimiento='" + diferimiento + '\'' +
                ", numeroPagos='" + numeroPagos + '\'' +
                ", plan='" + plan + '\'' +
                ", xid='" + xid + '\'' +
                ", cavv='" + cavv + '\'' +
                ", eci='" + eci + '\'' +
                ", status_3d='" + status_3d + '\'' +
                '}';
    }
}