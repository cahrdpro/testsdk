package com.oel.olipaysdk.utils;

import android.annotation.SuppressLint;
import android.device.DeviceManager;

public class AndroidUtils {

    @SuppressLint("MissingPermission")
    public static String getLastEightNumbersOfSerialNumber() {
        try {
            DeviceManager dev = new DeviceManager();
            String serial = dev.getDeviceId();
            if (serial == null) {
                throw new RuntimeException("Failed to get serial number, serial=" + serial);
            }
            if (serial.length() >= 8) {
                return serial.substring(serial.length() - 8);
            } else {
                return StringUtils.leftPadWithZeros(serial, 8);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get serial number, message:" + e.getMessage(), e);
        }
    }

    @SuppressLint("MissingPermission")
    public static String getSerialNumber() {
        try {
            DeviceManager dev = new DeviceManager();
            String serial = dev.getDeviceId();
            if (serial == null) {
                throw new RuntimeException("Failed to get serial number, serial=" + serial);
            }
            return serial;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get serial number, message:" + e.getMessage(), e);
        }
    }

}
