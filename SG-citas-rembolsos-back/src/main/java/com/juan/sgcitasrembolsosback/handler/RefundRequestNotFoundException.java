package com.juan.sgcitasrembolsosback.handler;


public class RefundRequestNotFoundException extends RuntimeException {
    public RefundRequestNotFoundException(String message) {
      super(message);
    }
}
