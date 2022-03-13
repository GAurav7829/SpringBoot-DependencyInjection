package com.grv.service;

//@Service
//added bean in di-config.xml file
//added xml file in GreetingServiceConfig class
public class PropertyInjectedGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hello World! - PropertyInjected";
	}

}
