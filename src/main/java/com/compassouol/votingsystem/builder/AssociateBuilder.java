package com.compassouol.votingsystem.builder;

import com.compassouol.votingsystem.model.Associate;
import com.compassouol.votingsystem.model.dto.AssociateDTO;
import org.springframework.stereotype.Component;

@Component
public class AssociateBuilder {

    public Associate associateDtoToEntity(AssociateDTO associateDTO) {
        return Associate.builder().name(associateDTO.getName()).document(associateDTO.getDocument()).build();
    }

}
