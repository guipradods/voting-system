package com.compassouol.votingsystem.controller;

import com.compassouol.votingsystem.model.dto.TopicDTO;
import com.compassouol.votingsystem.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TopicController {

    private final TopicService topicService;

    @PostMapping("/create")
    public ResponseEntity createTopic(@Valid @RequestBody TopicDTO topicDTO) {

        try {
            topicService.createTopic(topicDTO);
            return ResponseEntity.ok().body("Pauta criada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
