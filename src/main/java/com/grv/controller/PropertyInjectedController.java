package com.grv.controller;

import com.grv.service.GreetingService;

public class PropertyInjectedController {
	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
