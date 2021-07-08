package com.compassouol.votingsystem.exception;

public class InvalidDocumentException extends RuntimeException {

    public InvalidDocumentException() {
        super("CPF inválido");
    }

}
