package com.efacture.dev.service;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.ConfigInfo;
import com.efacture.dev.model.Consultation;
import com.efacture.dev.model.PaieTest;
import com.efacture.dev.model.Paiement;
import com.efacture.dev.model.PaiementPresta;
import com.efacture.dev.model.PayFactureGS2E;
import com.efacture.dev.model.PayFactureT24;
import com.efacture.dev.model.Transaction;
import com.efacture.dev.repository.ConsulteRepository;
import com.efacture.dev.repository.TransactionRepository;
import com.efacture.dev.serviceImpl.CmImpl;
import com.efacture.dev.serviceImpl.CommissionImpl;
import com.efacture.dev.serviceImpl.ConsultationImpl;
import com.efacture.dev.serviceImpl.PaiementImpl;


@Service
public class AppelApiService {
	
	private ConfigInfo confInfo;
	
	@Autowired
	private CmImpl marchandService;
	
	@Autowired
	private PaiementImpl paiementImpl;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CommissionImpl comImpl;
	
	@Autowired
	private ConsultationImpl consultationImpl;
	
	@Autowired
	private ConsulteRepository consultationRepository;

	private RestTemplate restTemplate;
	
	ConfigInfo config;
	
	
	
	@Autowired
	public AppelApiService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		try {
			this.confInfo = new ConfigInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public String saveFact( PaieTest api) {
		ConfigInfo config = null ;
		try {
			config = new ConfigInfo();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		HttpEntity<PaieTest> entity = new HttpEntity<>(api);	
		return restTemplate.exchange(config.getUrlT24() + "services/refTrtT24",
				HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	
	
	private PayFactureT24 jsonResult(String textJson){		
		PayFactureT24 ft = new PayFactureT24();
		
		
		try {
			JSONObject txtJson = new JSONObject(textJson);
			String v_statut=txtJson.getString("statut").toString();
			
			if(v_statut.equals("0")){
				ft.setStatut(txtJson.getString("statut").toString());
				ft.setNooper(txtJson.getString("Nooper").toString());
				ft.setRefExterne(txtJson.getString("refExterne").toString());
			}
			else
			{
				ft.setStatut(txtJson.getString("statut").toString());
				ft.setNooper(txtJson.getString("Nooper").toString());
				ft.setRefExterne("null");
			}
			
		} catch (Exception e) {
			ft= new PayFactureT24();
			e.printStackTrace();
		}
		
		return ft;
	}
	
	private PayFactureGS2E jsonResultGS2E(String textJson){		
		PayFactureGS2E retourPay = new PayFactureGS2E();
		try {
			JSONObject txtJson = new JSONObject(textJson);
			retourPay.setCodeTraitement(txtJson.getString("CodeTraitement").toString());
			retourPay.setMessageTraitement(txtJson.getString("MessageTraitement"));
			retourPay.setReferenceContratClient(txtJson.getString("ReferenceContratClient"));
			retourPay.setReferenceDeTransaction(txtJson.getString("ReferenceDeTransaction"));
			retourPay.setTypeTansaction(txtJson.getString("TypeTansaction").toString());
			retourPay.setNumeroRecu(txtJson.getString("NumeroRecu").toString());
			retourPay.setNumeroDeFacture(txtJson.getString("NumeroDeFacture").toString());
		} catch (Exception e) {
			retourPay= new PayFactureGS2E();
			e.printStackTrace();
		}
		
		return retourPay;
	}
	
	//paiment facture CIE prestataire
	
	@SuppressWarnings("unused")
	public String paieCie(PaiementPresta presta,String login){
		PayFactureT24 ft = new PayFactureT24();
		PayFactureGS2E factpay = new PayFactureGS2E();
		String resultatCIE = "{\"CodeTraitement\": 99,\"MessageTraitement\": \"ECHEC, SIB Insdiponible\",\"ReferenceContratClient\":\""+presta.getRefContrat()+"\" ,\"ReferenceDeTransaction\": ,\"TypeTansaction\": \"Reglement\",\"MontantReglement\":\""+presta.getMontantReglement()+"\" ,\"NumeroRecu\":\""+presta.getNumeroRecu()+"\"  ,\"NumeroDeFacture\": \""+presta.getRefFacture()+"\"}";
		PaieTest api= new PaieTest();
		CompteMarchand marchand = marchandService.getMarchand(login);	
		//List<Comptes> cpt = (List<Comptes>) marchand.getComptes();
		String cpts=null;
		String resPayT24 = null;
		//return cpts;	

		if(marchand != null){
			for (Comptes c:cpt){
				cpts =c.getCompte();
			}
		
		
		  Commission commission = comImpl.getCom((int) presta.getMontantReglement(), "CIE");
		
			long montantOper= presta.getMontantReglement()+commission.getCommissionBanque()+commission.getMntTimbre();
			api.setClient(marchand.getClient());
			api.setCompteDebit(cpts);
			api.setFacturier("CIE");
			api.setIdentifiantFacture(presta.getRefContrat());
			api.setMntFacture(presta.getMontantReglement());
			api.setMntFrais(commission.getCommissionBanque());
			api.setMntFraisMarchand(commission.getPourCommarch());
			api.setMntOper(montantOper);
			api.setMntTimbre(commission.getMntTimbre());
			resPayT24= saveFact(api);
		} 				
		ft =jsonResult(resPayT24);
		if (ft.getStatut().equals("0")){
			
			//enregistrement dans la table de consultation en attente de traitement côté CIE
			Consultation consult = consultationImpl.vueConsultation(
					new Date(), "En attente", presta.getMontantReglement(), cpts, "Total", 
					"CIE", presta.getDateExpfacture(),null, ft.getNooper(), presta.getRefContrat(), login,new Date(System.currentTimeMillis()), 
					login, ft.getRefExterne());
			
			//enregistrement dans la table de transation en attente de traitement côté CIE
			
			Transaction oper = new Transaction();
			
			oper.setCodeTraitement(Long.parseLong(ft.getStatut()));
			oper.setCodOper(presta.getCodeOperateur());
			oper.setCompteDebit(cpts);
			oper.setDatOper(new Date());
			oper.setFacturier("CIE");
			oper.setIdentifiantFacture(presta.getRefFacture());
			oper.setLibelleOper("PAIEMENT FACTURE CIE "+presta.getRefFacture()+" "+presta.getMontantReglement());
			oper.setMntFacture(presta.getMontantReglement());
			oper.setMntOper(presta.getMontantReglement()+api.getMntFrais()+api.getMntTimbre());
			oper.setMntFrais(api.getMntFrais());
			oper.setMntTimbre(api.getMntTimbre());
			oper.setStatutTraitement("En attente");
			
			Transaction transact = transactionRepository.save(oper);
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<PaiementPresta> entity = new HttpEntity<PaiementPresta>(presta, httpHeaders);			
			resultatCIE= restTemplate.exchange(this.confInfo.getUrlT24()+"serviceNMPF/reglFacture/cie", HttpMethod.POST, entity, String.class).getBody();
			factpay = jsonResultGS2E(resultatCIE);			
			
			
			if (factpay.getCodeTraitement().equals("0")){
				//mis à jour de consultation en Succès de traitement côté SIB
				
				consult.setStatut("Succès");
				consult.setReference(factpay.getReferenceDeTransaction());
				Consultation ftref = consultationRepository.save(consult);	
				
				//mis à jour de transaction en Succès de traitement côté SIB
				transact.setStatutTraitement("Succès");
				Transaction tr=transactionRepository.save(transact);
				
				//enregistrement dans la table de paiment en attente de traitement côté SIB				
				Paiement paieFact = paiementImpl.effectuerPaie(
						cpts, presta.getMontantReglement(), "CIE",api.getMntFrais(), api.getMntTimbre(),ft.getNooper(),
						presta.getRefFacture(), api.getMntOper(), new Date(), "Total", ft.getRefExterne());
							
				
			}							
			
		}		
		
		return resultatCIE;
	}
	
	
	//paiement facture SODECI prestataire
	

	@SuppressWarnings("unused")
	public  String paieSodeci(PaiementPresta presta,String login){
		PayFactureT24 ft = new PayFactureT24();
		PayFactureGS2E factpay = new PayFactureGS2E();
		String resultatSodeci="{\"CodeTraitement\": 99,\"MessageTraitement\": \"ECHEC, SIB Insdiponible\",\"ReferenceContratClient\":\""+presta.getRefContrat()+"\" ,\"ReferenceDeTransaction\": ,\"TypeTansaction\": \"Reglement\",\"MontantReglement\":\""+presta.getMontantReglement()+"\" ,\"NumeroRecu\":\""+presta.getNumeroRecu()+"\"  ,\"NumeroDeFacture\": \""+presta.getRefFacture()+"\"}";
		PaieTest api= new PaieTest();
		CompteMarchand marchand = marchandService.getMarchand(login);	
		List<Comptes> cpt = (List<Comptes>) marchand.getComptes();
		String cpts=null;
		String resPayT24 = null;
		//return cpts;	

		if(marchand != null){
			for (Comptes c:cpt){
				cpts =c.getCompte();
			}
			
			   Commission commission = comImpl.getCom((int) presta.getMontantReglement(), "SODECI");
			  
				long montantOper= presta.getMontantReglement()+commission.getCommissionBanque()+commission.getMntTimbre();
				api.setClient(marchand.getClient());
				api.setCompteDebit(cpts);
				api.setFacturier("SODECI");
				api.setIdentifiantFacture(presta.getRefContrat());
				api.setMntFacture(presta.getMontantReglement());
				api.setMntFrais(commission.getCommissionBanque());
				api.setMntFraisMarchand(commission.getPourCommarch());
				api.setMntOper(montantOper);
				api.setMntTimbre(commission.getMntTimbre());
				resPayT24= saveFact(api);
		} 				
		ft =jsonResult(resPayT24);
		if (ft.getStatut().equals("0")){
			
			//enregistrement dans la table de consultation en attente de traitement côté CIE
			Consultation consult = consultationImpl.vueConsultation(
					new Date(), "En attente", presta.getMontantReglement(), cpts, "Total", 
					"SODECI", presta.getDateExpfacture(),null, ft.getNooper(), presta.getRefContrat(), login,new Date(System.currentTimeMillis()), 
					login, ft.getRefExterne());
			
			//enregistrement dans la table de transation en attente de traitement côté CIE
			
			Transaction oper = new Transaction();
			oper.setCodeTraitement(Long.parseLong(ft.getStatut()));
			oper.setCodOper(presta.getCodeOperateur());
			oper.setCompteDebit(cpts);
			oper.setDatOper(new Date());
			oper.setFacturier("SODECI");
			oper.setIdentifiantFacture(presta.getRefFacture());
			oper.setLibelleOper("PAIEMENT FACTURE SODECI "+presta.getRefFacture()+" "+presta.getMontantReglement());
			oper.setMntFacture(presta.getMontantReglement());
			oper.setMntOper(presta.getMontantReglement()+api.getMntFrais()+api.getMntTimbre());
			oper.setMntFrais(api.getMntFrais());
			oper.setMntTimbre(api.getMntTimbre());
			oper.setStatutTraitement("En attente");
			
			Transaction transact = transactionRepository.save(oper);
			
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<PaiementPresta> entity = new HttpEntity<PaiementPresta>(presta, httpHeaders);
			
			resultatSodeci = restTemplate.exchange(this.confInfo.getUrlT24()+"/serviceNMPF/reglFacture/sodeci", HttpMethod.POST, entity, String.class).getBody();
			
			//String resultatCIE= restTemplate.exchange(this.confInfo.getUrlT24()+"serviceNMPF/reglFacture/cie", HttpMethod.POST, entity, String.class).getBody();
			factpay = jsonResultGS2E(resultatSodeci);			
			
			
			if (factpay.getCodeTraitement().equals("0")){
				//mis à jour de consultation en Succès de traitement côté SIB
				
				consult.setStatut("Succès");
				consult.setReference(factpay.getReferenceDeTransaction());
				Consultation ftref = consultationRepository.save(consult);	
				
				//mis à jour de transaction en Succès de traitement côté SIB
				transact.setStatutTraitement("Succès");
				Transaction tr=transactionRepository.save(transact);
				
				//enregistrement dans la table de paiment en attente de traitement côtéSIB				
				Paiement paieFact = paiementImpl.effectuerPaie(
						cpts, presta.getMontantReglement(), "CIE",api.getMntFrais(), api.getMntTimbre(),ft.getNooper(),
						presta.getRefFacture(), api.getMntOper(), new Date(), "Total", ft.getRefExterne());
							
				
			}
				
		}
		
		
		return resultatSodeci;
	}
	

}
