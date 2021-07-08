package com.compassouol.votingsystem.controller;

import com.compassouol.votingsystem.model.dto.VoteDTO;
import com.compassouol.votingsystem.service.VoteService;
import com.compassouol.votingsystem.util.VoteUtil;
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

        if(!VoteUtil.checkDocumentValid(voteDTO)) {
            return ResponseEntity.badRequest().body("CPF inválido");
        } else if(!voteService.checkTopicExists(voteDTO.getTopic())) {
            return ResponseEntity.badRequest().body("Pauta não existe");
        } else if(voteService.checkDocumentVoted(voteDTO.getDocument(), voteDTO.getTopic())) {
            return ResponseEntity.badRequest().body("Esse associado já votou nessa pauta");
        }

        try {
            voteService.mountVote(voteDTO);
            return ResponseEntity.ok().body("Voto Computado!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
