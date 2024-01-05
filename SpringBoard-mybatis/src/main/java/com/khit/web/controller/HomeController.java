package com.khit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	@GetMapping("/global_error")
	public String error() {
		return "/exception/global_error";
	}
	// "/"경로에서 404에러 발생
	@GetMapping("favicon.ico")
	@ResponseBody
	public void returnNoFavicon() {
		
	}
}
