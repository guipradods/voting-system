package com.compassouol.votingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DocumentAlreadyVotedException extends RuntimeException{

    public DocumentAlreadyVotedException() {
        super("Esse associado já votou nessa pauta");
    }

}
