package com.compassouol.votingsystem.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AssociateDTO {

    @NotNull
    private String name;
    @NotNull
    private String document;

}
