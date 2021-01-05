package com.comexport.usuario.model;

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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String Name;
	   
	private String Email;
	   
	private Date Birthdate;
	   
	private Date Createdat;
	   
	private Date Updatedat;
	   
	private Byte Enabled;
	   
	private Long Role_id;
}
