package com.oel.olipaysdk.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpTransaccionesResponse {

    List<Transaccion> arrayOfTransaccion = new ArrayList<>();

    public List<Transaccion> getArrayOfTransaccion() {
        return arrayOfTransaccion;
    }

    public void setArrayOfTransaccion(List<Transaccion> arrayOfTransaccion) {
        this.arrayOfTransaccion = arrayOfTransaccion;
    }

    @Override
    public String toString() {
        return "OpTransaccionesResponse{" +
                "arrayOfTransaccion=" + arrayOfTransaccion +
                '}';
    }

    public static class Transaccion {
        Integer comercioId;
        String comercio;
        String tipoMovimiento;
        String origenTransaccion;
        String CanalTransaccion;
        String transaccionId;
        BigDecimal monto;
        Integer codigoRespuesta;
        String resultado;
        String referenciaBanco;
        String codigoAprobacion;
        String afiliacion;
        String fechaTransaccion;
        String horaTransaccion;
        Date fechaRegistro;
        String tarjeta;
        String titular;
        String mes;
        String anio;
        String emisor;
        String marca;
        String tipo;
        String ARQC;
        String AID;
        String TSI;
        String TVR;
        String APN;
        String AL;
        Integer firmado;
        String usurio;
        String serieLector;

        public Integer getComercioId() {
            return comercioId;
        }

        public void setComercioId(Integer comercioId) {
            this.comercioId = comercioId;
        }

        public String getComercio() {
            return comercio;
        }

        public void setComercio(String comercio) {
            this.comercio = comercio;
        }

        public String getTipoMovimiento() {
            return tipoMovimiento;
        }

        public void setTipoMovimiento(String tipoMovimiento) {
            this.tipoMovimiento = tipoMovimiento;
        }

        public String getOrigenTransaccion() {
            return origenTransaccion;
        }

        public void setOrigenTransaccion(String origenTransaccion) {
            this.origenTransaccion = origenTransaccion;
        }

        public String getCanalTransaccion() {
            return CanalTransaccion;
        }

        public void setCanalTransaccion(String canalTransaccion) {
            CanalTransaccion = canalTransaccion;
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

        public Integer getCodigoRespuesta() {
            return codigoRespuesta;
        }

        public void setCodigoRespuesta(Integer codigoRespuesta) {
            this.codigoRespuesta = codigoRespuesta;
        }

        public String getResultado() {
            return resultado;
        }

        public void setResultado(String resultado) {
            this.resultado = resultado;
        }

        public String getReferenciaBanco() {
            return referenciaBanco;
        }

        public void setReferenciaBanco(String referenciaBanco) {
            this.referenciaBanco = referenciaBanco;
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

        public Date getFechaRegistro() {
            return fechaRegistro;
        }

        public void setFechaRegistro(Date fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
        }

        public String getTarjeta() {
            return tarjeta;
        }

        public void setTarjeta(String tarjeta) {
            this.tarjeta = tarjeta;
        }

        public String getTitular() {
            return titular;
        }

        public void setTitular(String titular) {
            this.titular = titular;
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

        public String getEmisor() {
            return emisor;
        }

        public void setEmisor(String emisor) {
            this.emisor = emisor;
        }

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public String getARQC() {
            return ARQC;
        }

        public void setARQC(String ARQC) {
            this.ARQC = ARQC;
        }

        public String getAID() {
            return AID;
        }

        public void setAID(String AID) {
            this.AID = AID;
        }

        public String getTSI() {
            return TSI;
        }

        public void setTSI(String TSI) {
            this.TSI = TSI;
        }

        public String getTVR() {
            return TVR;
        }

        public void setTVR(String TVR) {
            this.TVR = TVR;
        }

        public String getAPN() {
            return APN;
        }

        public void setAPN(String APN) {
            this.APN = APN;
        }

        public String getAL() {
            return AL;
        }

        public void setAL(String AL) {
            this.AL = AL;
        }

        public Integer getFirmado() {
            return firmado;
        }

        public void setFirmado(Integer firmado) {
            this.firmado = firmado;
        }

        public String getUsurio() {
            return usurio;
        }

        public void setUsurio(String usurio) {
            this.usurio = usurio;
        }

        public String getSerieLector() {
            return serieLector;
        }

        public void setSerieLector(String serieLector) {
            this.serieLector = serieLector;
        }

        @Override
        public String toString() {
            return "Transaccion{" +
                    "comercioId=" + comercioId +
                    ", comercio='" + comercio + '\'' +
                    ", tipoMovimiento='" + tipoMovimiento + '\'' +
                    ", origenTransaccion='" + origenTransaccion + '\'' +
                    ", CanalTransaccion='" + CanalTransaccion + '\'' +
                    ", transaccionId='" + transaccionId + '\'' +
                    ", monto=" + monto +
                    ", codigoRespuesta=" + codigoRespuesta +
                    ", resultado='" + resultado + '\'' +
                    ", referenciaBanco='" + referenciaBanco + '\'' +
                    ", codigoAprobacion='" + codigoAprobacion + '\'' +
                    ", afiliacion='" + afiliacion + '\'' +
                    ", fechaTransaccion='" + fechaTransaccion + '\'' +
                    ", horaTransaccion='" + horaTransaccion + '\'' +
                    ", fechaRegistro=" + fechaRegistro +
                    ", tarjeta='" + tarjeta + '\'' +
                    ", titular='" + titular + '\'' +
                    ", mes='" + mes + '\'' +
                    ", anio='" + anio + '\'' +
                    ", emisor='" + emisor + '\'' +
                    ", marca='" + marca + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", ARQC='" + ARQC + '\'' +
                    ", AID='" + AID + '\'' +
                    ", TSI='" + TSI + '\'' +
                    ", TVR='" + TVR + '\'' +
                    ", APN='" + APN + '\'' +
                    ", AL='" + AL + '\'' +
                    ", firmado=" + firmado +
                    ", usurio='" + usurio + '\'' +
                    ", serieLector='" + serieLector + '\'' +
                    '}';
        }

    }
}
