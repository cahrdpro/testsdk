package com.oel.olipaysdk.controller;

public class TransactionOngoingException extends QpayControllerException {

    private final String numeroTransaccion;

    public TransactionOngoingException(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }
}
