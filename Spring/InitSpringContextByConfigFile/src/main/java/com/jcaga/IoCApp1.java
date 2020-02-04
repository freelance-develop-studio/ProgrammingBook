package com.jcaga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IoCApp1 {
	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src\\main\\resources\\beans.xml");
		
		CityService cityBean = (CityService) context.getBean("city");
		
		cityBean.citiName();
	}
	
}
