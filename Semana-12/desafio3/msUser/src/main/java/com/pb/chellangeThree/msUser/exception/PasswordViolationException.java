package com.pb.chellangeThree.msUser.exception;

public class PasswordViolationException extends RuntimeException {

    public PasswordViolationException (String message) {
        super(message);
    }
}
