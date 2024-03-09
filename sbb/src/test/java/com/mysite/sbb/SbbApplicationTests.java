package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Test
	void testJpa() {
	
		for(int i=101; i<=300; i++) {
			
			Question question = new Question();
			question.setSubject(i+"번 째 질문입니다.");
			question.setCreateDate(LocalDateTime.now());
			question.setContent(i+"번 질문 내용 입니다.");
			
			questionRepository.save(question);
			
		}
		
		
		
	}

}
