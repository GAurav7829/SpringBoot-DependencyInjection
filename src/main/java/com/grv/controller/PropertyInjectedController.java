package com.grv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.grv.service.GreetingService;

@Controller
public class PropertyInjectedController {
	@Autowired
	@Qualifier("propertyInjectedGreetingService")
	public GreetingService greetingService;
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
}
