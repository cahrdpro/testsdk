package com.oel.olipaysdk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    static SimpleDateFormat isoZonedDateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", java.util.Locale.getDefault());
    static SimpleDateFormat zonedDateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", java.util.Locale.getDefault());
    static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault());
    static SimpleDateFormat mexicanDateTimeFormatter = new SimpleDateFormat("M/d/yyyy h:mm a", java.util.Locale.getDefault());
    static SimpleDateFormat mexicanDateFormatter = new SimpleDateFormat("M/d/yyyy", java.util.Locale.getDefault());

    public static Date createDateFromDateString(String value) {
        try {
            return isoZonedDateTimeFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        try {
            return zonedDateTimeFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        try {
            return dateTimeFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        try {
            return dateFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        try {
            return mexicanDateTimeFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        try {
            return mexicanDateFormatter.parse(value);
        } catch (ParseException e) {
            // try next format
        }
        return null;
    }


    public static Date createDateFromIsoDateTimeString(String value) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", java.util.Locale.getDefault());
        try {
            return formatter.parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date aYearAgo() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        c.setTimeInMillis(0);
        c.set(year, month, day, 0, 0, 0);
        c.add(Calendar.YEAR, -1);
        return c.getTime();
    }

    public static Date daysAgo(int days) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        c.setTimeInMillis(0);
        c.set(year, month, day, 0, 0, 0);
        c.add(Calendar.DATE, -days);
        return c.getTime();
    }

    public static Date twoDaysAgo() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        c.setTimeInMillis(0);
        c.set(year, month, day, 0, 0, 0);
        c.add(Calendar.DATE, -2);
        return c.getTime();
    }

    public static Date twoDaysFromNow() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
        c.setTimeInMillis(0);
        c.set(year, month, day, 0, 0, 0);
        c.add(Calendar.DATE, 2);
        return c.getTime();
    }

}
