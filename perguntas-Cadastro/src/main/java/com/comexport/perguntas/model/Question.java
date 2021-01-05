package com.comexport.perguntas.model;

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
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private Long Id_user;
	   
	private Long Id_flag;
	   
	private String Comment;
	   
	private Byte Resolved;
	   
	private Date Createdat;
	   
	private Date Updatedat;

}
