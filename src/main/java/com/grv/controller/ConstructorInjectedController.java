package com.grv.controller;

import com.grv.service.GreetingService;

public class ConstructorInjectedController {
	private final GreetingService service;

	public ConstructorInjectedController(GreetingService service) {
		super();
		this.service = service;
	}
	
	public String getGreeting() {
		return service.sayGreeting();
	}
}
