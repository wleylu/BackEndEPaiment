package com.efacture.dev.conttroller;

import java.util.Arrays;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;

import org.springframework.web.client.RestTemplate;


import com.efacture.dev.model.ConfigInfo;
import com.efacture.dev.model.PaieTest;
import com.efacture.dev.model.PaiementPresta;
import com.efacture.dev.model.TrameFacture;
import com.efacture.dev.service.AppelApiService;




@CrossOrigin("*")
@RestController
@RequestMapping("/Api")
public class AppelApiController {
	private ConfigInfo confInfo;

	@Autowired
	private AppelApiService apiService;
	
	private RestTemplate restTemplate;

	@Autowired
	public AppelApiController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		try {
			this.confInfo = new ConfigInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@PostMapping("/pay")
	public String saveFacture(@RequestBody PaieTest api) {
		return apiService.saveFact(api);
	}

//	@PostMapping("/pay/cie")
//	public String factureCie(@RequestBody PaiementGS2E api) {
//		return apiService.factureCie(api);
//	}

//	@Value("${spring.datasource.url}")
//	private String data;
//	

	@RequestMapping(value = "/facture/{identifiant}")
	public String getFactureList(@PathVariable String identifiant) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/getfacturecie/" + identifiant,
						HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/facture/cie/{identifiant}")
	public String getFactureListCie(@PathVariable String identifiant) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(restTemplate
				.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/consulfact/cie/" + identifiant,
						HttpMethod.GET, entity, String.class)
				.getBody());
		try {
		     JSONObject jsonObject = new JSONObject(restTemplate
						.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/consulfact/cie/" + identifiant,
								HttpMethod.GET, entity, String.class)
						.getBody());
		     //String stringfact=jsonObject.getString("ListeDesFactures");
//		     String JSON = "http://www.json-generator.com/j/cglqaRcMSW?indent=4";
//		     JSONObject jsonObject3 = new JSONObject("http://www.json-generator.com/j/cglqaRcMSW?indent=4"); // <-- Problem here!
		     System.out.println(jsonObject);

		}catch (JSONException err){
		     
		     System.out.println("Error " + err.toString());
		}
		return restTemplate
				.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/consulfact/cie/" + identifiant,
						HttpMethod.GET, entity, String.class)
				.getBody();
	}

	@RequestMapping(value = "/facture/sodeci/{identifiant}")
	public String getFactureListSodeci(@PathVariable String identifiant) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate
				.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/consulfact/sodeci/" + identifiant,
						HttpMethod.GET, entity, String.class)
				.getBody();
	}
	
	
	@RequestMapping(value = "/paie/cie")
	public String paie(@RequestBody PaiementPresta presta) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<PaiementPresta> entity = new HttpEntity<PaiementPresta>(presta, httpHeaders);
		
		return restTemplate.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/reglFacture/cie", HttpMethod.POST, entity, String.class).getBody();
	}
	

	
	@PostMapping(value = "/paie/cie/{login}")
	public String paiefacturecie(@RequestBody PaiementPresta presta,@PathVariable  String login) {			
		return apiService.paieCie(presta,login);				
	}
	
	
	
	@RequestMapping(value = "/paie/sodeci")
	public String paieSodeci(@RequestBody PaiementPresta presta) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<PaiementPresta> entity = new HttpEntity<PaiementPresta>(presta, httpHeaders);
		
		return restTemplate.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/reglFacture/sodeci", HttpMethod.POST, entity, String.class).getBody();
		
		
	}
	
	@RequestMapping(value = "/paie/sodeci/{login}")
	public String paiefactureSodeci(@RequestBody PaiementPresta presta,@PathVariable String login) {		
		return apiService.paieSodeci(presta, login)	;	
	}
	
	
	@RequestMapping(value = "/envoisms")
	public String envoiSMS(@RequestParam String numero, @RequestParam String message) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		System.out.println(this.confInfo.getUrlSMS()+"to="+numero+"&content=MON+TEST");
		return restTemplate
				.exchange(this.confInfo.getUrlSMS()+"to="+numero+"&content="+message,
						HttpMethod.GET, entity, String.class)
				.getBody();
		
	}
	
}
