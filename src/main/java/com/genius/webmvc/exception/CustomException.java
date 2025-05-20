package com.genius.webmvc.exception;

public class CustomException extends Exception {
    CustomException (String errorMsg) {
        super(errorMsg);
    }
}
