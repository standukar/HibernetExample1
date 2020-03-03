package com.rab3.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.DriverEntity;
import com.rab3.repositories.DriverRepository;

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		DriverRepository dr = (DriverRepository) ctx.getBean("driverRepository");
		
		DriverEntity de = new DriverEntity();
		de.setName("abcd efg");
		de.setAddress("2393 lee hwy");
		de.setAge(20);
		de.setState("VA");
		dr.save(de);
		
	}

}
