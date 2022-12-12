package com.efacture.dev.conttroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.efacture.dev.model.ConfigInfo;


@CrossOrigin("*")
@RestController
public class ConsumeWebService {
   
	@Autowired(required = true)
   private RestTemplate restTemplate;
	

   @RequestMapping(value = "/template/signalitique/{client}")
   public String getProductList(@PathVariable String client) {
	   ConfigInfo config = null ;
		try {
			config = new ConfigInfo();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	try {
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);	   
	      return restTemplate.exchange(config.getUrlT24() + "services/clientInfT24/"+client, HttpMethod.GET, entity, String.class).getBody();
	} catch (Exception e) {		
		return null;
	}
      
   }
   
   
//   @PostMapping("/Api/facture/cie") 
//   public String paiePrestataire (@RequestBody PaiementGS2E gs2e) {
//	   return apiService.paiementPrestataire(gs2e);
//   }
	
	  @Bean 
	  public RestTemplate restTemplate() { return new RestTemplate(); }
	 
}