package com.rab3.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rab3.entities.DriverEntity;
import com.rab3.repositories.DriverRepository;

public class UpdateDriverMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

		DriverRepository dr = (DriverRepository) ctx.getBean("driverRepository");

		System.out.println("Select by address = 7374 lee hwy");
		DriverEntity d1 = dr.getByAddress("7374 lee hwy");
		if (d1 != null) {
			d1.setAge(24);
			d1.setName("Siddharth Tandukar");
			d1.setDeleted(false);
			d1.setAddress("7374 lee hwy apt 201");

			dr.update(d1);
			
		}

		
	}

}
