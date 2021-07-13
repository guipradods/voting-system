package com.compassouol.votingsystem.repository;

import com.compassouol.votingsystem.model.Topic;
import com.compassouol.votingsystem.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByDocumentAndTopic(String document, Topic topic);

    @Query("SELECT count(v) FROM Vote v WHERE v.topic = :topic and lower(v.vote) = 'sim'")
    Optional<Integer> countAllByVoteEqualsYes(Topic topic);

    @Query("SELECT count(v) FROM Vote v WHERE v.topic = :topic and (lower(v.vote) = 'não' or lower(v.vote) = 'nao')")
    Optional<Integer> countAllByVoteEqualsNo(Topic topic);

}
