package com.jcaga.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcaga.service.GenericWelcomeService;

@Controller
public class WelcomeController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping("/")
	public String doWelcome(Model model) {
		
		// 1. Retrieving the processed data
		List<String> welcomeMessages =  welcomeService.getWelcomeMessages("Jiri Caga");
		
		// 2. Add data to the model
		model.addAttribute("myWelcomeMessages",welcomeMessages);
		
		// 3. Return logical view name
		return "welcome"; // /WEB-INF/views/welcome.jsp
	}

}
