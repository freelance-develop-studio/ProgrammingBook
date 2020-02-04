package com.jcaga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jcaga.domain.Department;
import com.jcaga.domain.HumanResourceDepartment;
import com.jcaga.domain.Organization;

public class DIConstructorApp {
	
	public static void main(String[] args) {
		// Create application context (container)
		ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\resources\\beans.xml");
		
		// Acess to the bean from containner
		Organization organization = (Organization) context.getBean("myorg");
		
		// Invoke company slogan via the bean
		System.out.println(organization.corporateSlogan());
		
		// Print department details
		Department humanResourceDepartment = (Department) context.getBean("myHrDeparment");
		System.out.println(humanResourceDepartment.hiringStatus(5500));
		
		// Close application context (container)
		((FileSystemXmlApplicationContext) context).close();
		
	}
	
}
