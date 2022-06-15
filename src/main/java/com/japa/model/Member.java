package com.japa.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.japa.common.FieldMatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
@FieldMatch(first = "confirmPassword", second = "password", message = "비밀번호가 일치 하지 않음")
public class Member {

//	@Size(min=2, max=5, message = "이름은 한글 또는 영어 2~5글자이어야 합니다.")
	@Pattern(regexp = "^[가-힣|a-z|A-Z]{2,5}", message = "이름은 한글 또는 영어 2~5글자이어야 합니다.")
	private String userName;
	
	@Email(message = "이메일 형식이 아닙니다.")
	@NotEmpty(message = "이메일을 입력하세요")
	private String email;
	
	@Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "비밀번호는 숫자, 문자, 특수문자 포함 8~15자리 이내여야합니다.")
	private String password;
	private String confirmPassword;
	
}
