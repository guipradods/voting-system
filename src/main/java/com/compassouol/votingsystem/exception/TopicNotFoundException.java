package com.compassouol.votingsystem.exception;

public class TopicNotFoundException extends RuntimeException {

    public TopicNotFoundException() {
        super("Pauta não encontrada");
    }

}
