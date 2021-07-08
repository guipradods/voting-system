package com.compassouol.votingsystem.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VoteDTO {

    @NotNull
    private String vote;
    @NotNull
    private String document;
    @NotNull
    private Long topic;

}
