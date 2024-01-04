package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.web.dto.SampleDTO;

@Controller //RestController(문자(json) 반환)
public class SampleController {
	
	@GetMapping("/exam01")
	public String exam01(Model model) {
		model.addAttribute("serverTime", new java.util.Date());
		return "/sample/exam01";
	}
	// /exam02?name=우영우&age=21
	@GetMapping("/exam02")
	public String exam02(@ModelAttribute SampleDTO sampleDTO) {
		return "/sample/exam02";
	}
	
	@GetMapping("/exam03")
	public @ResponseBody SampleDTO exam03() {
		SampleDTO dto = new SampleDTO();
		dto.setName("홍길동");
		dto.setAge(30);
		return dto;
	}
	
}
