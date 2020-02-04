package com.jcaga.serviceimpl;

import java.util.Random;

import com.jcaga.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs organization, " + companyName +
				" offers world class Cloud computing infrastructure." + 
				"\nThe annual income exceededs " + random.nextInt(revenue) + " dollars.";
		return service;
	}

}
