package com.compassouol.votingsystem.repository;

import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByDocumentAndTopic(String document, Topic topic);

}
