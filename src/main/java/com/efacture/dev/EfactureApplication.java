package com.efacture.dev;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//import com.efacture.dev.model.Facturier;
//import com.efacture.dev.model.UserAudite;
//import com.efacture.dev.model.Utilisateur;
//import com.efacture.dev.repository.UserAuditeRespository;
//import com.efacture.dev.service.ServiceFacturier;
//import com.efacture.dev.serviceImpl.FacturieImpl;
//import com.efacture.dev.serviceImpl.UserAuditeImpl;
//import com.efacture.dev.serviceImpl.UserServiceImpl;


import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.serviceImpl.CmImpl;
import com.efacture.dev.serviceImpl.TransacImpl;

//import com.efacture.dev.repository.UserRepository;

//import com.efacture.dev.serviceImpl.UserServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableSwagger2
@RestController
public class EfactureApplication extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	private CmImpl cmImpl;
	
	@Autowired
	private TransacImpl transacImpl;
//	@Autowired
//	private UserServiceImpl user;
//	
//	@Autowired
//	private UserRepository utlisateur;
	
//	@Autowired
//	private CommissionRepository com;
//	

	public static void main(String[] args) {
		SpringApplication.run(EfactureApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EfactureApplication.class);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World from Tomcat";
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		
	//	transacImpl.verifieCodeConfiramtion("R2", "C2", "85488");
		
		/*
		 * CompteMarchandDTO march = cmImpl.getBenificiaire("R2");
		 * System.out.println(march.toString());
		 */
		
	}
	
	
	

}
