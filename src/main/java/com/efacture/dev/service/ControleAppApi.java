package com.efacture.dev.service;


import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.efacture.dev.model.ConfigApp;

public class ControleAppApi {
	
	private ConfigApp app;

	public ControleAppApi() throws Exception {
		
		app = new ConfigApp();
		
	}
	
	public String getTokenApp(String login) {
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.set("login", login);
		//headers.set("tokenef", "");
		
		//HttpEntity<Model> request = new HttpEntity<Model>(model, headers);
		
		String e = restTemplate.postForObject(app.getUrlApi()+ "serviceNMPF/authConnect", headers, String.class);
		
		System.out.println("Method post : " + e);
		
		
		return e;
	}
}
