package com.oel.olipaysdk.utils;

public class StringUtils {

    public static String mask(String value) {
        if (value == null) {
            return null;
        }
        return "***" + value.length() + "***";
    }

    public static String maskCardNumber(String value) {
        String lastFourDigits = cardNumberLastFourDigits(value);
        if (lastFourDigits == null) {
            return null;
        }

        return "****" + lastFourDigits;
    }


    public static String cardNumberLastFourDigits(String tarjeta) {
        if (tarjeta == null || tarjeta.length() < 6) {
            return null;
        }
        String numbers = tarjeta
                .toLowerCase()
                .replaceAll("f", "")
                .replaceAll("F", "");
        if (numbers.length() < 4) {
            return numbers;
        }
        return numbers.substring(numbers.length() - 4);
    }

    public static String upperCase(String value) {
        if (value == null) {
            return null;
        }
        return value.toUpperCase();
    }

    public static String trim(String value) {
        if (value == null) {
            return null;
        }
        return value.trim();
    }

    public static String replaceAll(String value, String regex, String replacement) {
        if (value == null) {
            return null;
        }
        return value.replaceAll(regex, replacement);
    }

    public static boolean isBlank(String value) {
        if (value == null || value.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }

    public static String nullToEmpty(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }

    public static String defaultValueIfBlank(String value, String defaultValue) {
        if (isBlank(value)) {
            return defaultValue;
        }
        return value;
    }

    public static String leftPadWithZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

}
