package com.efacture.dev.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

public class ConfigApp {

	private final String UrlApi;
	private final String email;
	private final String emailcc;

	public ConfigApp() throws Exception {
		
		Properties appConfig = new Properties();		
		
		File classPathResource = ResourceUtils.getFile("classpath:config.properties");
		
		InputStream inputStream = new FileInputStream(classPathResource);
		appConfig.load(inputStream);
		
//		appConfig.load(ConfigApp.class.getClassLoader()
//				.getResourceAsStream("com/efacture/dev/config/config.properties"));
//		
		this.UrlApi = appConfig.getProperty("url");
		this.email=appConfig.getProperty("email");
		this.emailcc=appConfig.getProperty("emailcc");
		
	}

	public String getUrlApi() {
		return UrlApi;
	}

	public String getEmail() {
		return email;
	}

	public String getEmailcc() {
		return emailcc;
	}
	
	
	
	
	
}
