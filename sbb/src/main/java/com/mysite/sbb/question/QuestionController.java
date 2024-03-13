package com.mysite.sbb.question;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

	
	 private final QuestionService questionService;
	 private final UserService userService;
	 
	
	@GetMapping("/list")
	public String list(Model model , @RequestParam(name = "page" , defaultValue = "0") int page) {
		
		Page<Question> paging = questionService.getList(page);
		model.addAttribute("paging" , paging);
		
		return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model , @PathVariable(name = "id") Integer id , AnswerForm answerForm) {
		
		Question question = questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/create")
	public String create(QuestionForm questionform) {
		return "question_form";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create")
	public String questCreate(@Valid QuestionForm questionForm , BindingResult bindingResult, Principal principal) {
		
		
		
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		SiteUser siteUser = userService.getUser(principal.getName());
		questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
		
		return "redirect:/question/list";
	}
	
	
	
	
	
	
}
