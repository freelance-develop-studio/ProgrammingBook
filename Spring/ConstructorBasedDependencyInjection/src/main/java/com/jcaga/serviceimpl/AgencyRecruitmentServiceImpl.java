package com.jcaga.serviceimpl;

import java.util.Random;

import com.jcaga.service.RecruimentService;

public class AgencyRecruitmentServiceImpl implements RecruimentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecrutments) {
		Random random = new Random();
		String hiringFact = "\n" + companyName + "'s " + departmentName + " hired " +
				random.nextInt(numberOfRecrutments) + " employees " + 
				"using various hiring agencies.";
		return hiringFact;
	}

}
