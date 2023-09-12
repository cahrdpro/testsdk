package com.oel.olipaysdk.client;

import java.net.UnknownHostException;

public class QpayClientConnectionException extends QpayClientException {

    public QpayClientConnectionException(UnknownHostException e) {
        super(e);
    }

}