package com.oel.olipaysdk.client;

public interface OpErrorResponse {

    Integer getCcErrorCode();
    String getCcReturnMsg();
    String getProcReturnMsg();

}