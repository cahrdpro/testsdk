package com.oel.olipaysdk.controller;

public class QpParamsMemory {
    String identificador;
    String contrasena;
    double monto;
    double propina;
    String transaccionId;
    String referencia;
    Integer diferimiento;
    Integer plan;
    Integer numeroPagos;
    String deviceId;

    @Override
    public String toString() {
        return "QpRealizaTransaccionParams{" +
                "identificador=" + identificador +
                ", contrasena='" + contrasena + '\'' +
                ", transaccionId='" + transaccionId + '\'' +
                ", monto=" + monto +
                ", propina=" + propina +
                ", referencia='" + referencia + '\'' +
                ", diferimiento=" + diferimiento +
                ", plan=" + plan +
                ", numeroPagos=" + numeroPagos +
                ", deviceId=" + deviceId +
                '}';
    }
}