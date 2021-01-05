package com.comexport.respostas.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.comexport.respostas.model.Answer;

public class WebsiteAnswerValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Answer.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {

		Answer answer = (Answer) obj;

		if (checkInputString(answer.getComment())) {
			errors.rejectValue("Comment", "Comment.empty");
		}
		
		if (checkInputString(answer.getId_question().toString())) {
			errors.rejectValue("Id_question", "Id_question.empty");
		}
		
		if (checkInputString(answer.getId_user().toString())) {
			errors.rejectValue("Id_user", "Id_user.empty");
		}

	}
	
    private Boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
}
