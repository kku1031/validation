package com.japa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.japa.model.Member;
import com.japa.validation.MemberValidator;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping("/success")
	public String success() {
		return "member/success";
	}
	
	@GetMapping("/register")
	public String registerForm(Member member) {
		return "member/register";
	}
	
	@PostMapping("/register")
	public String register(@Valid Member member, Errors errors) {
//		new MemberValidator().validate(member, errors);
		if(errors.hasErrors()) {
			return "member/register";
		}
		return "redirect:success";
	}
}
