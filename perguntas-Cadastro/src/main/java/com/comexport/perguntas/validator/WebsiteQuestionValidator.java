package com.comexport.perguntas.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.comexport.perguntas.model.Question;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WebsiteQuestionValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Question.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {

		Question question = (Question) obj;

		if (checkInputString(question.getComment())) {
			errors.rejectValue("Comment", "Comment.empty");
		}
		
		if (checkInputString(question.getId_flag().toString())) {
			errors.rejectValue("Flag", "Flag.empty");
		}
		
	}
	
    private Boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
}
