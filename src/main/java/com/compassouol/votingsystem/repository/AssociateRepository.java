package com.compassouol.votingsystem.repository;

import com.compassouol.votingsystem.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {

    Optional<Associate> findByDocument(String document);

}
