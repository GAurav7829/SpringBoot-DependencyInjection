package com.grv.service;

//@Service
//@Primary
//added bean in GreetingServiceConfig class
public class PrimaryGreetingService implements GreetingService {
	@Override
	public String sayGreeting() {
		return "Hello World! - Primary";
	}
}
