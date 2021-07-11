package com.compassouol.votingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TopicClosedException extends RuntimeException {

    public TopicClosedException() {
        super("A sessão de votação está fechada para esta pauta");
    }

}
