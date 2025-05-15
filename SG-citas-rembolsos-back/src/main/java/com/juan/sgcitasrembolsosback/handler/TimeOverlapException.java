package com.juan.sgcitasrembolsosback.handler;

public class TimeOverlapException extends RuntimeException {
    public TimeOverlapException(String message) {
        super(message);
    }
}
