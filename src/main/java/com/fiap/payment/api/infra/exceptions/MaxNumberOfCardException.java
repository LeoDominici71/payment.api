package com.fiap.payment.api.infra.exceptions;

public class MaxNumberOfCardException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public MaxNumberOfCardException(String msg) {
        super(msg);
    }
}
