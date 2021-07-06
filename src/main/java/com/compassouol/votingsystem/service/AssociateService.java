package com.compassouol.votingsystem.service;

import com.compassouol.votingsystem.builder.AssociateBuilder;
import com.compassouol.votingsystem.model.dto.AssociateDTO;
import com.compassouol.votingsystem.repository.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AssociateService {

    private final AssociateRepository associateRepository;
    private final AssociateBuilder associateBuilder;

    public void createAssociate(AssociateDTO associateDTO) {

        var newAssociate = associateBuilder.associateDtoToEntity(associateDTO);
        associateRepository.save(newAssociate);

    }

    public Boolean checkDocumentExists(AssociateDTO associateDTO) {
        return associateRepository.findByDocument(associateDTO.getDocument()).isPresent();
    }

}
