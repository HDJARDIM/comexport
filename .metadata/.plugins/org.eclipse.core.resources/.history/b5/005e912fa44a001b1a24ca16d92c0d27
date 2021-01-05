package com.comexport.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;

import com.comexport.usuario.validator.WebsiteUserValidator;

@SpringBootApplication
public class UsuarioCadastroApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(UsuarioCadastroApplication.class, args);
	}

    public void configureValidatingRepositoryEventListener(
      ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", new WebsiteUserValidator());
    }	
}
