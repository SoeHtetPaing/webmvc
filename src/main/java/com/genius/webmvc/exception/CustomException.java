package com.genius.webmvc.exception;

public class CustomException extends Exception {
    public CustomException(String errorMsg) {
        super(errorMsg);
    }
}
