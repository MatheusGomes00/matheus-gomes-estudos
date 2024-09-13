package com.pbCompass.parkApi.exception;

public class UsernameUniqueViolationException extends RuntimeException {

    public UsernameUniqueViolationException(String message) {
        super(message);
    }
}
