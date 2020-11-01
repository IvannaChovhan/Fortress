package com.company.exception;

public class NotEnoughSpaceForFortressException extends RuntimeException {
    public NotEnoughSpaceForFortressException(String message) {
        super(message);
    }
}
