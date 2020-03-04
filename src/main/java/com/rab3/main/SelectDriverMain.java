package com.rab3.main;

import java.util.List;


import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.DriverEntity;
import com.rab3.repositories.DriverRepository;

public class SelectDriverMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		DriverRepository dr = (DriverRepository) ctx.getBean("driverRepository");
		
		DriverEntity driver = dr.getById(2);
		
		if(dr != null) {
		System.out.println(driver.toString());
		}	
	
		
		System.out.println("select by state = MD");
		List<DriverEntity> drivers = (List<DriverEntity>) dr.getByState("MD");
		
		for(DriverEntity d : drivers) {
		System.out.println(d.toString());
		
		
	}

}
}
