package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@RequiredArgsConstructor //private final에 해당하는 속성들을 필요로 하는 생성자가 자동으로 생성되기 때문에 의존성이 자동으로 주입되는 것 
@Getter
@Setter

public class HelloLombok {

	private final String hello;
	private final int lombok;
	
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok("hello", 5);
		
		System.out.println(helloLombok.getHello());
		System.out.println(helloLombok.getLombok());
		
		// helloLombok.set 세터 메서드 사용 불가
		
	}
	
	
}
