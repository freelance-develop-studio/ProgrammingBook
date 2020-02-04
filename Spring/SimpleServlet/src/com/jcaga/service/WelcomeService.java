package com.jcaga.service;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {
	
	public List<String> getWelcomeMessages(String name){
		List<String> result = new ArrayList<>();
		
		// Add data to the list
		result.add("Hello");
		result.add(name);
		result.add(" , welcome to the Spring course. :-)");
		
		return result;
	}

}
