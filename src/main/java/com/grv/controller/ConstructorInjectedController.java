package com.grv.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.grv.service.GreetingService;

@Controller
public class ConstructorInjectedController {
	private final GreetingService service;

	public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService service) {
		super();
		this.service = service;
	}
	
	public String getGreeting() {
		return service.sayGreeting();
	}
}
