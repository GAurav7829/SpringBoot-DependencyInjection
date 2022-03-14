package com.grv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.grv.datasource.FakeDataSource;
import com.grv.repositories.EnglishGreetingRepository;
import com.grv.repositories.EnglishGreetingRepositoryImpl;
import com.grv.service.ConstructorGreetingService;
import com.grv.service.GreetingService;
import com.grv.service.PrimaryGreetingService;
import com.grv.service.SetterBasedGreetingService;
import com.i18n.I18nGreetingServiceFactory;

@Configuration
@ImportResource("classpath:di-config.xml")
//@PropertySource("classpath:datasource.properties")//add external properties file
//added in application.properties
@EnableConfigurationProperties(ConstructorBasedConfiguration.class)
public class GreetingServiceConfig {
	//get datasource value from external properties file
//	@Bean
//	FakeDataSource fakeDataSource(@Value("${com.grv.username}") String username,
//			@Value("${com.grv.password}") String password, @Value("${com.grv.jdbcUrl}") String jdbcUrl) {
//		FakeDataSource fakeDataSource = new FakeDataSource();
//		fakeDataSource.setUsername(username);
//		fakeDataSource.setPassword(password);
//		fakeDataSource.setJdbcUrl(jdbcUrl);
//		return fakeDataSource;
//	}
	@Bean
	FakeDataSource fakeDataSource(ConstructorBasedConfiguration configuration) {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(configuration.getUsername());
		fakeDataSource.setPassword(configuration.getPassword());
		fakeDataSource.setJdbcUrl(configuration.getJdbcUrl());
		return fakeDataSource;
	}

	// another way of creating beans without using @Service annotation
	@Bean
	ConstructorGreetingService constructorGreetingService() {
		return new ConstructorGreetingService();
	}

	@Bean
	SetterBasedGreetingService setterBasedGreetingService() {
		return new SetterBasedGreetingService();
	}

	@Bean
	@Primary // make bean primary
	PrimaryGreetingService primaryGreetingService() {
		return new PrimaryGreetingService();
	}

	@Bean
	EnglishGreetingRepository englishGreetingRepository() {
		return new EnglishGreetingRepositoryImpl();
	}
	/*
	 * @Bean("i18nService")
	 * 
	 * @Profile("EN")//set profile to bean I18nEnglishGreetingService
	 * i18nService(EnglishGreetingRepository englishGreetingRepository) {
	 * //i18nService is service name OR set in @Bean("i18nService") return new
	 * I18nEnglishGreetingService(englishGreetingRepository); }
	 * 
	 * //OR otherway of doing this
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