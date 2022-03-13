package com.grv.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class ProtoptypeBean {
	
	
	public ProtoptypeBean() {
		System.out.println("Creating a Protopype Bean...");
	}

	public String getMyScope() {
		return "I'm Prototype";
	}
}
