package com.oel.olipaysdk.client;

import com.oel.olipaysdk.utils.DateUtils;

import org.ksoap2.serialization.SoapObject;

import java.math.BigDecimal;
import java.util.Date;

public class SoapObjectUtils {

    static Integer getIntegerByName(SoapObject soapObject, String name) {
        try {
            return Integer.parseInt(soapObject.getPrimitivePropertySafelyAsString(name));
        } catch (Exception e) {
            return null;
        }
    }

    static String getStringByName(SoapObject soapObject, String name) {
        return soapObject.getPrimitivePropertySafelyAsString(name);
    }

    static BigDecimal getBigDecimalByName(SoapObject soapObject, String name) {
        try {
            return new BigDecimal(soapObject.getPrimitivePropertySafelyAsString(name));
        } catch (Exception e) {
            return null;
        }
    }

    static Date getDateByName(SoapObject soapObject, String name) {
        return DateUtils.createDateFromIsoDateTimeString(soapObject.getPrimitivePropertySafelyAsString(name));
    }
}