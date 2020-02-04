package com.jcaga;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCApp2 {


	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		CityService cityBean = (CityService) context.getBean("city");
		
		cityBean.citiName();
	}

}
