package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String detail(Model model , @PathVariable(name = "id") Integer id) {
		
		Question question = questionService.getQuestion(id);
		model.addAttribute("question",question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String create() {
		return "question_form";
	}
	
	
	@PostMapping("/create")
	public String questCreate(@RequestParam(name = "subject") String subject ,
							  @RequestParam(name = "content") String content) {
		
		questionService.create(subject, content);
		
		return "redirect:/question/list";
	}
	
	
	
	
	
	
}
