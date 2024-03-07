package com.mysite.sbb;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //번호
	
	@Column(length = 200)
	private String subject; //질의 제목
	
	@Lob
	private String content; //질의 내용
	
	@Column
	private LocalDateTime createDate; //질의 날짜
	
	@OneToMany(mappedBy = "question" ,
			   cascade = CascadeType.REMOVE ,
			   fetch = FetchType.LAZY)
	private List<Answer> answerList;
	
}
