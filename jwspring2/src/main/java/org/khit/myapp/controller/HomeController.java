package org.khit.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //component »ó¼Ó
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
}
