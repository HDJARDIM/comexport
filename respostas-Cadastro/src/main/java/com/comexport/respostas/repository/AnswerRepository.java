package com.comexport.respostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comexport.respostas.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {}
