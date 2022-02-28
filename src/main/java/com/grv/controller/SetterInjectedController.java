package com.grv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.grv.service.GreetingService;

@Controller
public class SetterInjectedController {
	private GreetingService greetingService;
	@Autowired
	@Qualifier("setterBasedGreetingService")
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String getGreeting() {
		return greetingService.sayGreeting();
	}
	
}
