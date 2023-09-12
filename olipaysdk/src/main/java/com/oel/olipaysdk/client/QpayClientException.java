package com.oel.olipaysdk.client;

public class QpayClientException extends RuntimeException {

    public QpayClientException(String message) {
        super(message);
    }

    public QpayClientException(Throwable cause) {
        super(cause);
    }


}