package com.oel.olipaysdk.client;

import java.net.SocketTimeoutException;

import javax.net.ssl.SSLException;

public class QpayClientConnectionLostException extends QpayClientException {

    public QpayClientConnectionLostException(SocketTimeoutException e) {
        super(e);
    }

    public QpayClientConnectionLostException(SSLException e) {
        super(e);
    }

}
