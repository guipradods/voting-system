package com.compassouol.votingsystem.service;

import com.compassouol.votingsystem.builder.VoteBuilder;
import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.dto.VoteDTO;
import com.compassouol.votingsystem.repository.TopicRepository;
import com.compassouol.votingsystem.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class VoteService {

    private final VoteRepository voteRepository;
    private final VoteBuilder voteBuilder;
    private final TopicRepository topicRepository;

    public void mountVote(VoteDTO voteDTO) {

        var vote = voteBuilder.voteDtoToEntity(voteDTO);
        vote.setTopic(this.findTopic(voteDTO.getTopic()));
        voteRepository.save(vote);

    }

    public Topic findTopic(Long topic_id) {
        return topicRepository.findById(topic_id).get();
    }

    public Boolean checkTopicExists(Long topic_id) {
        return topicRepository.findById(topic_id).isPresent();
    }

    public Boolean checkDocumentVoted(String document, Long topic_id) {
        Optional<Topic> topic = topicRepository.findById(topic_id);
        return voteRepository.findByDocumentAndTopic(document, topic.get()).isPresent();
    }

}
