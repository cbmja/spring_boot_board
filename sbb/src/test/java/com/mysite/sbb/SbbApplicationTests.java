package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Test
	void testJpa() {
	
		Optional<Question> oq = questionRepository.findById(2); //optional로 감싸지 않을 경우 findById(2)가 null일 경우 오류 발생하기 때문에 리턴타입이 optional인듯
		//assertTrue(oq.isPresent()); //값이 존재하는지 안하는지
		
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("spring 부트는  스프링 boot 입니다.");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q);
		
		answerRepository.save(a);
		
		
		
	}

}
