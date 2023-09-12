package com.oel.olipaysdk.utils;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Convert {

    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String hexStringToString(String data) {
        if (data == null) {
            return null;
        }
        try {
            return new String(hexStringToBytes(data), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String stringToHexString(String data) {
        if (data == null) {
            return null;
        }
        try {
            char[] ch = data.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : ch) {
                int i = (int) c;
                builder.append(Integer.toHexString(i).toUpperCase());
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String hexStringToNumberString(String data) {
        byte[] bytes = hexStringToBytes(data);
        String result = "";
        for (byte aByte : bytes) {
            result = result + aByte;
        }
        return result;
    }

    public static String byteToHexString(final byte data) {
        final char[] out = new char[2];
        // two characters form the hex value.
        out[0] = DIGITS[(0xF0 & data) >>> 4];
        out[1] = DIGITS[0x0F & data];
        return new String(out);
    }

    public static String bytesToHexString(final byte[] data) {
        if (data == null) {
            return null;
        }
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }
        return new String(out);
    }

    public static byte[] hexStringToBytes(final String data) throws HexException {
        char[] chars = data.toCharArray();
        final int len = chars.length;
        if ((len & 0x01) != 0) {
            throw new HexException("Odd number of characters.");
        }
        final byte[] out = new byte[len >> 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(chars[j], j) << 4;
            j++;
            f = f | toDigit(chars[j], j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }
        return out;
    }

//    public static WritableMap toWritableMap(Map<String, Object> map) {
//
//    }
//
//    public static WritableArray toWritableArray(Collection collection) {
//        WritableArray array = Arguments.createArray();
//        for (Object item : collection) {
//            if (item instanceof Map) {
//                array.pushMap(toWritableMap((Map) item));
//            } else if (item instanceof Collection) {
//                array.pushArray(toWritableArray((Collection) item));
//            } else if (item instanceof String) {
//                array.pushString((String) item);
//            } else if (item instanceof Boolean) {
//                array.pushBoolean((Boolean) item);
//            } else if (item instanceof Double) {
//                array.pushDouble((Double) item);
//            } else if (item instanceof Integer) {
//                array.pushInt((Integer) item);
//            } else if (item == null) {
//                array.pushNull();
//            }
//        }
//        return array;
//    }

    private static int toDigit(final char ch, final int index) throws HexException {
        final int digit = Character.digit(ch, 16);
        if (digit == -1) {
            throw new HexException("Illegal hexadecimal character " + ch + " at index " + index);
        }
        return digit;
    }

    public static String toString(Integer value) {
        if (value == null) {
            return null;
        }
        return Integer.toString(value);
    }

    public static String toString(Boolean value) {
        if (value == null) {
            return null;
        }
        return Boolean.toString(value);
    }

    public static String toString(BigDecimal value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String toAmountString(Double value) {
        if (value == null) {
            return null;
        }
        return toBigDecimalAmount(value).toString();
    }

    public static Integer toInteger(String value) {
        if (value == null) {
            return null;
        }
        return Integer.valueOf(value);
    }

    public static BigDecimal toBigDecimalAmount(Double value) {
        if (value == null) {
            return null;
        }
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }

    public static String toString(Date value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String toString(Map data) {
        if (data == null) {
            return null;
        }
        return data.toString();
    }

    public static String toString(List list) {
        if (list == null) {
            return null;
        }
        return list.toString();
    }


    public static final class HexException extends RuntimeException {
        private HexException(String message) {
            super(message);
        }
    }

}
