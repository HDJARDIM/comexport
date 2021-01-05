package com.comexport.votos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comexport.votos.model.Vote_answer;

@Repository
public interface Vote_answerRepository extends JpaRepository<Vote_answer, Long> {}
