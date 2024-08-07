package com.fiap.payment.api.infra.exceptions;

public class GeneralClientSystemException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public GeneralClientSystemException(String msg) {
        super(msg);
    }
}
