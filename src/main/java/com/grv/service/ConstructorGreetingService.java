package com.grv.service;

//@Service
//added bean in GreetingServiceConfig class
public class ConstructorGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World! - Constructor";
	}

}
