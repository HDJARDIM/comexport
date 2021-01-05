package com.comexport.votos.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.comexport.votos.model.Vote_answer;

public class WebsiteVoteAnswerValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Vote_answer.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {

		Vote_answer vote_answer = (Vote_answer) obj;

		if (checkInputString(vote_answer.getId_question().toString())) {
			errors.rejectValue("Id_question", "Id_question.empty");
		}
		
		if (checkInputString(vote_answer.getId_question().toString())) {
			errors.rejectValue("Id_answer", "Id_answer.empty");
		}
		
		if (checkInputString(vote_answer.getId_user().toString())) {
			errors.rejectValue("Id_user", "Id_user.empty");
		}

		if (checkInputString(vote_answer.getScore().toString())) {
			errors.rejectValue("Score", "Score.empty");
		}

	}
	
    private Boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
    
}
