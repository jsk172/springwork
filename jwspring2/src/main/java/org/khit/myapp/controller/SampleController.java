package org.khit.myapp.controller;

import org.khit.myapp.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class SampleController {
	
//	@RequestMapping("/join")
	@GetMapping("/join")
	public String joinForm() { //가입 폼
		
		return "user/join";
	}
	
	@PostMapping("/join")
	public String joinPost(UserDTO userDTO) {
		System.out.println("userDTO=" + userDTO);
		return "redirect:/"; //index로 강제 이동
	}
	
	//가입처리
	@GetMapping("/join2")
	public String join(UserDTO userDTO) {
		//스프링은 파라미터(함수의 매개변수)로 name 속성을 받음(request 사용안함)
		
		System.out.println(userDTO);
		return "index";
	}
	
	
	@GetMapping("/join3")
	public String join(@RequestParam("name") String name) {
		//스프링은 파라미터(함수의 매개변수)로 name 속성을 받음(request 사용안함)
		
		System.out.println("이름 : " + name);
		return "index";
	}
	
	
}
