package com.japa.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.japa.model.Board;

public class BoardValidator implements Validator {
	
	@Override 
	public boolean supports(Class<?> clazz) {
		return Board.class.isAssignableFrom(clazz);
		//보드타입만 검사
	}

	@Override
	public void validate(Object target, Errors errors) {
		Board board = (Board) target;
		if(board.getTitle() == null || board.getTitle().trim().isEmpty()) {
			errors.rejectValue("title", "required");
			//board에 적용된 필드값, 에러코드
			return;
		}
			if(board.getTitle().length()<3 || board.getTitle().length()>100) {
				errors.rejectValue("title", "length");
			}
			
		}
	}


