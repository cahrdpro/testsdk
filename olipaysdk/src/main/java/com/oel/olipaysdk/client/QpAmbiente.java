package com.oel.olipaysdk.client;

public enum QpAmbiente {
    PRODUCTION,
    VGS,
    VGS_LIVE,
    TEST;

    public static QpAmbiente from(String text) {
        if (text != null && text.toUpperCase().equals(PRODUCTION.name())) {
            return PRODUCTION;
        }
        if (text != null && text.toUpperCase().equals(VGS.name())) {
            return VGS;
        }
        if (text != null && text.toUpperCase().equals(VGS_LIVE.name())) {
            return VGS_LIVE;
        }
        return TEST;
    }
}
