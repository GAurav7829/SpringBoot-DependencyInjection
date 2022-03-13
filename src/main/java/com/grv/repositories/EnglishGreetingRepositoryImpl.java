package com.grv.repositories;

//added bean to GreetingServiceConfig
public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

	@Override
	public String getGreeting() {
		return "Hello World from EnglishGreetingRepository";
	}

}
