package com.compassouol.votingsystem.builder;

import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.dto.TopicDTO;
import org.springframework.stereotype.Component;

@Component
public class TopicBuilder {

    public Topic topicDtoToEntity(TopicDTO topicDTO) {
        return Topic.builder().description(topicDTO.getDescription()).build();
    }

}
