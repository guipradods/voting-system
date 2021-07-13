package com.compassouol.votingsystem.service;

import com.compassouol.votingsystem.builder.TopicBuilder;
import com.compassouol.votingsystem.exception.TopicNotFoundException;
import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.dto.TopicDTO;
import com.compassouol.votingsystem.repository.TopicRepository;
import com.compassouol.votingsystem.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TopicService {

    private final TopicRepository topicRepository;
    private final VoteRepository voteRepository;
    private final TopicBuilder topicBuilder;

    public void createTopic(TopicDTO topicDTO) {

        var newTopic = topicBuilder.topicDtoToEntity(topicDTO);
        topicRepository.save(newTopic);

    }

    public void openSession(Long id) throws InterruptedException {

        var topic = topicRepository.findById(id).orElseThrow(TopicNotFoundException::new);
        topic.setIsOpen(true);
        topicRepository.save(topic);
        Thread.sleep(60000);
        topic.setIsOpen(false);
        topicRepository.save(topic);

    }

    public Optional<Topic> findTopic(Long topic_id) {
        return topicRepository.findById(topic_id);
    }

    public Boolean checkTopicIsOpen(Topic topic) {
        return topic.getIsOpen();
    }

    public Integer showYesVotes(Long topic_id) {
        var topic = topicRepository.findById(topic_id);
        return voteRepository.countAllByVoteEqualsYes(topic.get()).orElseThrow();
    }

    public Integer showNoVotes(Long topic_id) {
        var topic = topicRepository.findById(topic_id);
        return voteRepository.countAllByVoteEqualsNo(topic.get()).orElseThrow();
    }
}
