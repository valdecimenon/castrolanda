package com.softgraf.primavera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("model")
	public String homeModel(Model model) {
		
		return "home";  // view
	}
}
