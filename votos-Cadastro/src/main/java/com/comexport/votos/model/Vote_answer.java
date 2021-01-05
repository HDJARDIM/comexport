package com.comexport.votos.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vote_answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_question;
	
	private Long Id_answer;
	   
	private Long Id_user;
	   
	private Long Score;
	   
	private Date Createdat;
	   
	private Date Updatedat;

}
