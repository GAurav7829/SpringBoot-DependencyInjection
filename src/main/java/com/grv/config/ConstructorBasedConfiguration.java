package com.grv.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("com.grv")
//added in GreetingServiceConfig
public class ConstructorBasedConfiguration {
	private final String username;
	private final String password;
	private final String jdbcUrl;
	
	public ConstructorBasedConfiguration(String username, String password, String jdbcUrl) {
		super();
		this.username = username;
		this.password = password;
		this.jdbcUrl = jdbcUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	
}
