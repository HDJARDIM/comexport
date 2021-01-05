package com.comexport.perguntas.controller;

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

import com.comexport.perguntas.model.Question;
import com.comexport.perguntas.repository.QuestionRepository;

@RestController
@RequestMapping({"/question"})
public class QuestionController {

	private QuestionRepository repository;
	
	QuestionController(QuestionRepository questionRepository) {
		this.repository = questionRepository;
	}
	
	@GetMapping
	public List<Question> pesquisar() {
		return repository.findAll();
	}
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Question> pesquisarporid(@PathVariable Long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Question create(@RequestBody Question question) {
		return repository.save(question);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity update(@PathVariable("id") Long id,
											@RequestBody Question question) {
		Date today = (Date) Calendar.getInstance().getTime();
		return repository.findById(id)
				.map(record -> {
					record.setId_user(question.getId_user());
					record.setId_flag(question.getId_flag());
					record.setComment(question.getComment());
					record.setResolved(question.getResolved());
					record.setUpdatedat(today);
					Question updated = repository.saveAndFlush(record);
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
