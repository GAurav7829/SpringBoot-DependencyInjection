package com.i18n;

import com.grv.repositories.EnglishGreetingRepository;
import com.grv.service.GreetingService;

//@Profile("EN")
//@Service("i18nService")
//added bean in GreetingServiceConfig class
public class I18nEnglishGreetingService implements GreetingService {
	
	private final EnglishGreetingRepository englishGreetingRepository;

	public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
		super();
		this.englishGreetingRepository = englishGreetingRepository;
	}

	@Override
	public String sayGreeting() {
		return "Hello World - I18nEnglishGreetingService";
	}

}
