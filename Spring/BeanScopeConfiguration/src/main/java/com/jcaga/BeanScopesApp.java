package com.jcaga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jcaga.domain.Organization;

public class BeanScopesApp {
	
	public static void main(String[] args) {
		// Create application context (container)
		ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\resources\\beans.xml");
		
		// Acess to the bean from containner
		Organization organization1 = (Organization) context.getBean("myorgSingleton");
		Organization organization2 = (Organization) context.getBean("myorgSingleton");
		organization2.setPostalCode("1234");
		compare(organization1, organization2);
		
		organization1 = (Organization) context.getBean("myorgPrototype");
		organization2 = (Organization) context.getBean("myorgPrototype");
		organization2.setPostalCode("12");
		compare(organization1, organization2);
		
		// Close application context (container)
		((FileSystemXmlApplicationContext) context).close();
		
	}
	
	public static void compare(Organization organization1, Organization organization2) {
		// Print organization details
		System.out.println(organization1);
		System.out.println(organization2);
		if (organization1 == organization2) {
			System.out.println("Singleton scope test: organization and organization2 point to the same instance");
		} else {
			System.out.println("Both organization and organization2 are separate instances.");
		}
	}
	
}
