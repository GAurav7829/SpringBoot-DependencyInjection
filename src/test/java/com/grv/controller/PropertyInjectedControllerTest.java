package com.grv.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.grv.service.ConstructorGreetingService;

public class PropertyInjectedControllerTest {
	
	PropertyInjectedController propertyInjectedController;
	
	@BeforeEach
	void setUp() {
		propertyInjectedController = new PropertyInjectedController();
		propertyInjectedController.greetingService = new ConstructorGreetingService();
	}
	
	@Test
	void getGreeting() {
		System.out.println(propertyInjectedController.getGreeting());
	}
}
