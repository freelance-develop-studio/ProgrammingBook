 package com.jcaga.serviceimpl;

import java.util.Random;

import com.jcaga.service.BusinessService;

public class EccomerceServiceImpl implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs organization, " + companyName +
				" provides an outstanding Eccomerce platform." + 
				"\nThe annual income exceededs " + random.nextInt(revenue) + " dollars.";
		return service;
	}

}
