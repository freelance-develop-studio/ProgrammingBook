package com.jcaga.serviceimpl;

import java.util.Random;

import com.jcaga.service.RecruimentService;

public class RefferalRecruitmentServiceImpl implements RecruimentService {

	public String recruitEmployees(String companyName, String departmentName, int numberOfRecrutments) {
		Random random = new Random();
		String hiringFact = "\n" + companyName + "'s " + departmentName + " hired " +
				random.nextInt(numberOfRecrutments) + " employees" + 
				"which were reffered to the company by employees.";
		return hiringFact;
	}

}
