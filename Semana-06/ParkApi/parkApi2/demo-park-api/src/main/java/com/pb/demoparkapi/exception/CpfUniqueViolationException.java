package com.pb.demoparkapi.exception;

public class CpfUniqueViolationException extends RuntimeException{

    public CpfUniqueViolationException(String message){
        super(message);
    }
}
