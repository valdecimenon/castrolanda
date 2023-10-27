package com.softgraf.primavera.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
		// localhost:8080/hello
//		@GetMapping("/hello")
//		public String hello(HttpServletRequest request) {
//			request.setAttribute("nome", "Valdeci");
//			// retorna o nome de uma view (arquivo html neste caso)
//			return "bemvindo";
//		}

		@GetMapping("/hello")  // endepoint ou rota
		public String hello(Model model) {
			model.addAttribute("nome", "Valdeci");
			// retorna o nome de uma view (arquivo html neste caso)
			return "bemvindo";
		}
		
}
