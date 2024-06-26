package com.demobreaker.circuit_breaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;

@Service
public class NameService { // It is just like a @bean to autowired
	// CircuitBreakerFactory to create interface and implements cloud.client 4j
	// provisions call the empolyee controller redirct to another name microservice
	// port after stop the name microservice it will return fallback by using
	// circuit breaker.

	@Autowired
	RestTemplate resttemplate;
	// private Object circuitBreakerFactory;

	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	public String callserviceName() {

		// CircuitBreakerFactory circuitBreakerFactory = new CircuitBreakerFactory();
		CircuitBreaker cb = circuitBreakerFactory.create("namecallservice");
		// run(torun , fallback)
		// to run -> api call(suppiler) and fallback when it occured.//
		return cb.run(() -> resttemplate.getForObject("http://localhost:8081/api/name", String.class ),
				throwable -> fallbackNameService());

	}

	public String fallbackNameService() {
		return "fall back return";

	}

}
