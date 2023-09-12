package com.oel.olipaysdk.client;

import java.math.BigDecimal;

public class OpVentaRequest {

    Integer comercioId;
    String contrasena;
    String modo;
    BigDecimal monto;
    BigDecimal propina;
    String transaccionId;
    String referencia;
    String tarjeta;
    String tipo;
    String mes;
    String anio;
    String digitos;
    String titular;
    String dirIp;
    String posEntryMode;
    String track2;
    String emvTags;
    String aid;
    String tvr;
    String tsi;
    String apn;
    String al;
    String arqc;
    String diferimiento;
    String numeroPagos;
    String plan;
    String qps;
    String deviceId;
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

    public BigDecimal getPropina() {
        return propina;
    }

    public void setPropina(BigDecimal propina) {
        this.propina = propina;
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

    public String getPosEntryMode() {
        return posEntryMode;
    }

    public void setPosEntryMode(String posEntryMode) {
        this.posEntryMode = posEntryMode;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getEmvTags() {
        return emvTags;
    }

    public void setEmvTags(String emvTags) {
        this.emvTags = emvTags;
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

    public String getQps() {
        return qps;
    }

    public void setQps(String qps) {
        this.qps = qps;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OpVentaRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", modo='" + modo + '\'' +
                ", monto=" + monto +
                ", propina=" + propina +
                ", transaccionId='" + transaccionId + '\'' +
                ", referencia='" + referencia + '\'' +
                ", tarjeta='" + tarjeta + '\'' +
                ", tipo='" + tipo + '\'' +
                ", mes='" + mes + '\'' +
                ", anio='" + anio + '\'' +
                ", digitos='" + digitos + '\'' +
                ", titular='" + titular + '\'' +
                ", dirIp='" + dirIp + '\'' +
                ", posEntryMode='" + posEntryMode + '\'' +
                ", track2='" + track2 + '\'' +
                ", emvTags='" + emvTags + '\'' +
                ", aid='" + aid + '\'' +
                ", tvr='" + tvr + '\'' +
                ", tsi='" + tsi + '\'' +
                ", apn='" + apn + '\'' +
                ", al='" + al + '\'' +
                ", arqc='" + arqc + '\'' +
                ", diferimiento='" + diferimiento + '\'' +
                ", numeroPagos='" + numeroPagos + '\'' +
                ", plan='" + plan + '\'' +
                ", qps='" + qps + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
