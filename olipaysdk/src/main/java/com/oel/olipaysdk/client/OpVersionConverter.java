package com.oel.olipaysdk.client;

import org.ksoap2.serialization.SoapObject;

class OpVersionConverter {

static OpVersionResponse soapObjectToResponsePojo(SoapObject soapObject) {
        OpVersionResponse response = new OpVersionResponse();
        response.version = SoapObjectUtils.getStringByName(soapObject, "OpVersionResult");
        return response;
        }

        }
