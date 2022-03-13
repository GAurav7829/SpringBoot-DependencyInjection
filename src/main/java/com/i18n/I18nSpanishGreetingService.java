package com.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.grv.service.GreetingService;

//@Profile({"ES","default"})//setting the default profile
@Profile("ES")
@Service("i18nService")
public class I18nSpanishGreetingService implements GreetingService {

	@Override
	public String sayGreeting() {
		return "Hola Mundo - I18nSpanishGreetingService";
	}

}
