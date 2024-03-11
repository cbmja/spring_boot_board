package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateForm {

	
	@Size(min = 3 , max = 25)
	@NotEmpty(message = "id를 입력하세요")
	private String username;
	
	@NotEmpty(message = "비밀번호를 입력하세요")
	private String password1;

	@NotEmpty(message = "비밀번호 확인을 입력하세요")
	private String password2;
	
	@NotEmpty(message = "이메일을 입력하세요")
	@Email
	private String email;
	
}
