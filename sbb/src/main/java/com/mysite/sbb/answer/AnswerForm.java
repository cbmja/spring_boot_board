package com.mysite.sbb.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AnswerForm {

	
	@NotEmpty(message = "내용을 입력하세요")
	private String content;
	
}
