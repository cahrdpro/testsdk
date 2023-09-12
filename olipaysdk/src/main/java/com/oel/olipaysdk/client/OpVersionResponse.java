package com.oel.olipaysdk.client;

public class OpVersionResponse {

    String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "OpVersionResponse{" +
                "version='" + version + '\'' +
                '}';
    }

}