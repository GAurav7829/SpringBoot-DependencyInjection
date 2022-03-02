package com.grv.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"ES","default"})//setting the default profile
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hola Mundo - I18nSpanishGreetingService";
	}

}
