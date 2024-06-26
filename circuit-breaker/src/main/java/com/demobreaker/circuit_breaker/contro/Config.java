package com.demobreaker.circuit_breaker.contro;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	//This config help to redirect the service.
	
	 // to call all the products
	@Bean
	   @LoadBalanced//annotated bean will be added in spring context you will just  easy to autowired it @Autowired it.
		public RestTemplate getRest() {	
			RestTemplate resttemplate = new RestTemplate();
		    return resttemplate;
		}
	
	
	
	
	

}
