package com.jcaga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jcaga.domain.Organization;

public class DISetterApp {
	
	public static void main(String[] args) {
		// Create application context (container)
		ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\resources\\beans.xml");
		
		// Acess to the bean from containner
		Organization organization = (Organization) context.getBean("myorg");
		
		// Invoke company slogan via the bean
		System.out.println(organization.corporateSlogan());
		
		// Print organization details
		System.out.println(organization);
		System.out.println(organization.corporateService());
		
		// Close application context (container)
		((FileSystemXmlApplicationContext) context).close();
		
	}
	
}
