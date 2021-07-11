package com.compassouol.votingsystem.controller;

import com.compassouol.votingsystem.model.dto.VoteDTO;
import com.compassouol.votingsystem.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VoteController {

    private final VoteService voteService;

    @PostMapping()
    public ResponseEntity vote(@Valid @RequestBody VoteDTO voteDTO) {
        voteService.mountVote(voteDTO);
        return ResponseEntity.ok().body("Voto Computado!");
    }

}
