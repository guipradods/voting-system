package com.compassouol.votingsystem.builder;

import com.compassouol.votingsystem.model.Vote;
import com.compassouol.votingsystem.model.dto.VoteDTO;
import org.springframework.stereotype.Component;

@Component
public class VoteBuilder {

    public Vote voteDtoToEntity(VoteDTO voteDTO) {
        return Vote.builder().document(voteDTO.getDocument()).vote(voteDTO.getVote().toString()).build();
    }

}
