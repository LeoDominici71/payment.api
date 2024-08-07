package com.fiap.payment.api.infra.exceptions;

public class LimitExcedeedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LimitExcedeedException(String msg) {
        super(msg);
    }

}