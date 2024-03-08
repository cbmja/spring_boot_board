package com.mysite.sbb;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Answer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //번호
	
	@Lob
	private String content; //답변 내용
	
	@Column
	private LocalDateTime createDate; //답변 날짜
	
	@ManyToOne
	private Question question;
	
	
	
}
