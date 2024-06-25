package com.demobreaker.circuit_breaker.contro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobreaker.circuit_breaker.entity.Empolyee;
import com.demobreaker.circuit_breaker.service.NameService;


@RestController

public class EmployeController {
	
    @Autowired
	NameService nameservice;
			
	
	
 @GetMapping
 @RequestMapping("api/start")	
	
	
			
 public Empolyee getDetails( ) {
	 
				
		
	 Empolyee emp = new Empolyee();
	// to call the name from another service
	String name = nameservice.callserviceName();

	 emp.setId(1);
	 emp.setName(name);
	 emp.setSalary("15000");
	 return emp;
	  
	 
 }

}
