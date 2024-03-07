package com.mysite.sbb;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

	@GetMapping ("/hello")
	@ResponseBody // return값 자체를 그대로 결과로서 나타냄 -> 보통은 html 파일이나 jsp 등등
	public String hello() {
		
		return "Hello spring bo ot";
		
	}
	
	
}
