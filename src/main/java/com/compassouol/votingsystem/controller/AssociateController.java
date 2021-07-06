package com.compassouol.votingsystem.controller;

import com.compassouol.votingsystem.model.dto.AssociateDTO;
import com.compassouol.votingsystem.service.AssociateService;
import com.compassouol.votingsystem.util.AssociateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/associate")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AssociateController {

    private final AssociateService associateService;

    @PostMapping("/create")
    public ResponseEntity createAssociate(@Valid @RequestBody AssociateDTO associateDTO) {

        if(!AssociateUtil.checkDocumentValid(associateDTO)) {
            return ResponseEntity.badRequest().body("CPF inválido");
        } else if (associateService.checkDocumentExists(associateDTO)) {
            return ResponseEntity.badRequest().body("CPF já cadastrado");
        }

        try {
            associateService.createAssociate(associateDTO);
            return ResponseEntity.ok().body("Associado criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
