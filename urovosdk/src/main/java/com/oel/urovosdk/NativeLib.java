package com.oel.urovosdk;

public class NativeLib {

    // Used to load the 'urovosdk' library on application startup.
    static {
        System.loadLibrary("urovosdk");
    }

    /**
     * A native method that is implemented by the 'urovosdk' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}