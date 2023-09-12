package com.oel.olipaysdk.controller;

import java.util.UUID;

public class TransactionId {
    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0,20);
    }
}
