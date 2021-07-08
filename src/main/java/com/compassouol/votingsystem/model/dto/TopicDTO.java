package com.compassouol.votingsystem.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TopicDTO {

    @NotNull
    private String description;
    private Boolean isOpen;

}
