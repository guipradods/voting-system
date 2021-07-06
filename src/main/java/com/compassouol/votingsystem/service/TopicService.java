package com.compassouol.votingsystem.service;

import com.compassouol.votingsystem.builder.TopicBuilder;
import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.dto.TopicDTO;
import com.compassouol.votingsystem.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicBuilder topicBuilder;

    public void createTopic(TopicDTO topicDTO) {

        var newTopic = topicBuilder.topicDtoToEntity(topicDTO);
        topicRepository.save(newTopic);

    }

}
