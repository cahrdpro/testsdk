package com.oel.olipaysdk.client;
import org.ksoap2.SoapFault;
public class QpayClientSoapFaultException extends QpayClientException {

    public QpayClientSoapFaultException(SoapFault soapFault) {
        super(String.format("SoapFault faultcode=%s, faultstring=%s, faultactor=%s", soapFault.faultcode, soapFault.faultstring, soapFault.faultactor));
    }

}
