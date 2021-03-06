package com.compassouol.votingsystem.controller;

import com.compassouol.votingsystem.model.dto.TopicDTO;
import com.compassouol.votingsystem.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/open-session/{id}")
    public ResponseEntity openVoteSession(@PathVariable Long id) throws InterruptedException {

        topicService.openSession(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/result/{id}")
    public ResponseEntity showResult(@PathVariable Long id) {

        var yesVotes = topicService.showYesVotes(id);
        var noVotes = topicService.showNoVotes(id);
        return ResponseEntity.ok().body("Sim: " + yesVotes + "\n" + "Não: " + noVotes);

    }

}
