package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserRepository;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private AnswerRepository answerRepository;
	
	@Test
	void testJpa() {
	
		SiteUser user = new SiteUser();
		user.setUsername("test");
		user.setEmail("adsf@asdf.adsf");
		user.setPassword("adsfasd");
		userRepository.save(user);
		
		for(int i=1; i<=300; i++) {
			
			Question question = new Question();
			question.setSubject(i+"번 째 질문입니다.");
			question.setCreateDate(LocalDateTime.now());
			question.setContent(i+"번 질문 내용 입니다.");
			question.setAuthor(user);
			questionRepository.save(question);
			
		}
		
		
		
	}

}
