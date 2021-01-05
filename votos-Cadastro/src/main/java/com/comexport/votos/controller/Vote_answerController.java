package com.comexport.votos.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comexport.votos.model.Vote_answer;
import com.comexport.votos.repository.Vote_answerRepository;

@RestController
@RequestMapping({"/voteanswer"})
public class Vote_answerController {

	private Vote_answerRepository repository;
	
	Vote_answerController(Vote_answerRepository vote_answerRepository) {
		this.repository = vote_answerRepository;
	}
	
	@GetMapping
	public List<Vote_answer> pesquisar() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Vote_answer> pesquisarporid(@PathVariable Long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Vote_answer create(@RequestBody Vote_answer vote_answer) {
		return repository.save(vote_answer);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") Long id,
											@RequestBody Vote_answer vote_answer) {
		Date today = (Date) Calendar.getInstance().getTime();
		return repository.findById(id)
				.map(record -> {
					record.setId_question(vote_answer.getId_question());
					record.setId_answer(vote_answer.getId_answer());
					record.setId_user(vote_answer.getId_user());
					record.setUpdatedat(today);
					Vote_answer updated = repository.saveAndFlush(record);
					return ResponseEntity.ok().body(updated);
				}).orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity <?> delete(@PathVariable Long id) {
		return repository.findById(id)
				.map(record -> {
					repository.deleteById(id);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
