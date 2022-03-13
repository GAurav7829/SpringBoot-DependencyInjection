package com.grv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.grv.repositories.EnglishGreetingRepository;
import com.grv.repositories.EnglishGreetingRepositoryImpl;
import com.grv.service.ConstructorGreetingService;
import com.grv.service.GreetingService;
import com.grv.service.PrimaryGreetingService;
import com.grv.service.SetterBasedGreetingService;
import com.i18n.I18nGreetingServiceFactory;

@Configuration
@ImportResource("classpath:di-config.xml")
public class GreetingServiceConfig {	
	//another way of creating beans without using @Service annotation
	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}
	@Bean
	SetterBasedGreetingService setterBasedGreetingService() {
		return new SetterBasedGreetingService();
	}
	@Bean
	@Primary//make bean primary
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}
	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
/*	
	@Bean("i18nService")
	@Profile("EN")//set profile to bean
	I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) { //i18nService is service name OR set in @Bean("i18nService")
		return new I18nEnglishGreetingService(englishGreetingRepository);
	}
	
	//OR otherway of doing this
*/
	
	@Bean
	I18nGreetingServiceFactory i18nGreetingServiceFactory() {
		return new I18nGreetingServiceFactory();
	}
	
	@Bean("i18nService")
	@Profile("EN")
	GreetingService getI18nEnglishService() {
		return i18nGreetingServiceFactory().getI18nService("EN");
	}
	
}