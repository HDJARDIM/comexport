package com.comexport.usuario.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.comexport.usuario.model.User;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;


public class WebsiteUserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {

		User user = (User) obj;

		if (checkInputString(user.getName())) {
			errors.rejectValue("Name", "Name.empty");
		}
		
		if (checkInputString(user.getEmail())) {
			errors.rejectValue("Email", "Email.empty");
		}
		
		if (checkInpuDate((user.getBirthdate().toString()))) {
			errors.rejectValue("Birthdate", "Birthdate.invalid");
		}

		if (!isValidEmailAddress(user.getEmail())) {
			errors.rejectValue("Email", "Email.invalid");
		}
		
	}
	
    private Boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
    private Boolean checkInpuDate(String input) {
    	try {
    		Date today = new SimpleDateFormat("dd/MM/yyyy").parse(input);
    		return false;
    	}
    	catch(Exception e) {
    		return true;
    	}
    }
    
    public static boolean isValidEmailAddress(String email) {
	   boolean result = true;
	   try {
	      InternetAddress emailAddr = new InternetAddress(email);
	      emailAddr.validate();
	   } catch (AddressException ex) {
	      result = false;
	   }
	   return result;
    }    

}
