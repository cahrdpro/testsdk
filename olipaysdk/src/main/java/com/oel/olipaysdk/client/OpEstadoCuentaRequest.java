package com.oel.olipaysdk.client;

public class OpEstadoCuentaRequest {

    Integer comercioId;
    String contrasena;
    Integer periodo;
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

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OpEstadoCuentaRequest{" +
                "comercioId=" + comercioId +
                ", contrasena='" + contrasena + '\'' +
                ", periodo=" + periodo +
                ", version='" + version + '\'' +
                '}';
    }

}
