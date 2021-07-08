package com.compassouol.votingsystem.service;

import com.compassouol.votingsystem.builder.VoteBuilder;
import com.compassouol.votingsystem.exception.DocumentAlreadyVotedException;
import com.compassouol.votingsystem.exception.InvalidDocumentException;
import com.compassouol.votingsystem.exception.TopicNotFoundException;
import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.dto.VoteDTO;
import com.compassouol.votingsystem.repository.TopicRepository;
import com.compassouol.votingsystem.repository.VoteRepository;
import com.compassouol.votingsystem.util.VoteUtil;
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

        if(!VoteUtil.checkDocumentValid(voteDTO)) {
            throw new InvalidDocumentException();
        }

        vote.setTopic(this.findTopic(voteDTO.getTopic()).orElseThrow(TopicNotFoundException::new));

        if (this.checkDocumentVoted(voteDTO.getDocument(), voteDTO.getTopic())) {
            throw new DocumentAlreadyVotedException();
        }

        voteRepository.save(vote);

    }

    public Optional<Topic> findTopic(Long topic_id) {
        return topicRepository.findById(topic_id);
    }

    public Boolean checkTopicExists(Long topic_id) {
        return topicRepository.findById(topic_id).isPresent();
    }

    public Boolean checkDocumentVoted(String document, Long topic_id) {
        Optional<Topic> topic = topicRepository.findById(topic_id);
        return voteRepository.findByDocumentAndTopic(document, topic.get()).isPresent();
    }

}
