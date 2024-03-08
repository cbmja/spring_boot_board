package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/question")
public class QuestionController {

	
	 private final QuestionService questionService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Question> questionList = questionService.getList();
		model.addAttribute("questionList" , questionList);
		
		return "question_list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String detail(Model model , @PathVariable(name = "id") Integer id , AnswerForm answerForm) {
		
		Question question = questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String create(QuestionForm questionform) {
		return "question_form";
	}
	
	
	@PostMapping("/create")
	public String questCreate(@Valid QuestionForm questionForm , BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "question_form";
		}
		
		questionService.create(questionForm.getSubject(), questionForm.getContent());
		
		return "redirect:/question/list";
	}
	
	
	
	
	
	
}
