package com.demobreaker.circuit_breaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {
		
			@Autowired
			RestTemplate resttemplate;
			
			
			public String callserviceName(){
				
			 CircuitBreaker cb = CircuitBreakerFactory.create("namecallservice created");  
			return cb.run(()-> resttemplate.getForObject("http://localhost:8081/api/name", String.class	) ,throwable -> fallbackNameService());
			
			
			}
			
			
			public String fallbackNameService() {
				return "fall back method";
			
			
			
			
			}
			

}
