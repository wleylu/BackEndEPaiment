package com.efacture.dev.conttroller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.efacture.dev.model.ParaCommission;
import com.efacture.dev.model.Consultation;
import com.efacture.dev.model.CustomResponse;
import com.efacture.dev.repository.ConsulteRepository;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.serviceImpl.ConsultationImpl;//import com.efacture.dev.serviceImpl.FacturieImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class ConsulteController {
	@Autowired
	private ConsultationImpl consultationImpl;
	@Autowired
	private ConsulteRepository consulteRepository;

	@GetMapping("/consultation/{login}")
	public ResponseEntity<List<Consultation>> listeFacture(@PathVariable String login) {
		return ResponseEntity.ok(consultationImpl.consultePaie(login));
	}

	@PostMapping("/consultation/rechercheByref")
	public ResponseEntity<Consultation> rechercheByref(@RequestBody Consultation consultation) {
		Consultation consulte = consultationImpl.rechercheConsulteByref(consultation.getReference());
// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(consulte);
	}

	@PostMapping("/consultation/rechercheByFacturier")
	public ResponseEntity<Consultation> rechercheByFacturier(@RequestBody Consultation consultation) {
		Consultation consulte = consultationImpl.rechercheConsulteByFacturier(consultation.getFacturier());
// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(consulte);
	}

	@PostMapping("/consultation/rechercheByFiliale")
	public ResponseEntity<Consultation> rechercheByFiliale(@RequestBody Consultation consultation) {
		Consultation consulte = consultationImpl.rechercheByFiliale(consultation.getFiliale());
// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(consulte);
	} 

	@PostMapping("/consultation/historique")
	public ResponseEntity<Consultation> vueConsultation(@RequestBody Consultation consultation) {
		Consultation cons = consultationImpl.vueConsultation(consultation.getDateRegle(), consultation.getStatut(),
				consultation.getMontantDebite(), consultation.getNumCpt(), consultation.getTypeRegle(),
				consultation.getFacturier(), consultation.getDtExpFacture(), consultation.getReference(),
				consultation.getReferenceFT(), consultation.getIdentifiant(), consultation.getLogin(),
				consultation.getHeure(), consultation.getFiliale(), consultation.getReferenceExt());
		
		return ResponseEntity.ok(cons);
	}

	@GetMapping("/consultation/liste")
	public ResponseEntity<List<Consultation>> recupererHistorique() {
		return ResponseEntity.ok(consultationImpl.listHistorique());
	}

	@GetMapping("/consultation/recherche/{id}")
	public ResponseEntity<Optional<Consultation>> recherche(@PathVariable Long id) {
		return ResponseEntity.ok(consultationImpl.recherche(id));
	}

	@GetMapping("/consultation/compteur/{login}/{date_regle}")
	public ResponseEntity<Integer> compteur(@PathVariable String login, @PathVariable java.sql.Date date_regle) {
		return ResponseEntity.ok(consultationImpl.compteur(login, date_regle));
	}

	@GetMapping("/consultation/compteurMtn/{login}/{date_regle}")
	public ResponseEntity<Integer> compteurMtn(@PathVariable String login, @PathVariable java.sql.Date date_regle) {
		return ResponseEntity.ok(consultationImpl.compteurMtn(login, date_regle));
	}

	@GetMapping("/consultation/rechercheTransPeriode")
	public ResponseEntity<List<Consultation>> rechercheByPeriode(
			@RequestParam(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@RequestParam(value = "lastDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate) {
		return ResponseEntity.ok(consultationImpl.rechercheByPeriode(firstDate, lastDate));
	}
	
	@GetMapping("/consultation/consultationPaiement")
	public ResponseEntity<List<Consultation>> rechercheTransaction(

			@RequestParam(value = "firstDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@RequestParam(value = "lastDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate,
			@RequestParam(value = "login") String login, @RequestParam(value = "referenceFt") String referenceFt,
			@RequestParam(value = "facturier") String facturier,
			@RequestParam(value = "identifiant") String identifiant) {
		return ResponseEntity.ok(
				consultationImpl.rechercheTransaction(firstDate, lastDate, login, referenceFt, facturier, identifiant));
	}

	@GetMapping("/consultation/recherche")
	public ResponseEntity<List<Consultation>> recherche(

			@RequestParam(value = "login") String login, @RequestParam(value = "referenceFt") String referenceFt,
			@RequestParam(value = "facturier") String facturier,
			@RequestParam(value = "identifiant") String identifiant) {
		return ResponseEntity.ok(consultationImpl.recherche(login, referenceFt, facturier, identifiant));
	}

	@PutMapping("/consultation/statut/{referenceFT}")
	public ResponseEntity<Consultation> statutUpdate(@PathVariable("referenceFT") String referenceFT,
			@RequestBody Consultation consultation) {
		Optional<Consultation> consultations = consulteRepository.findByReferenceFT(referenceFT);

		if (consultations.isPresent()) {
			Consultation _consul = consultations.get();
			_consul.setStatut(consultation.getStatut());

			return new ResponseEntity<>(consulteRepository.save(_consul), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("/consultation/reference/{referenceFT}")
	public ResponseEntity<Consultation> referenceUpdate(@PathVariable("referenceFT") String referenceFT,
			@RequestBody Consultation consultation) {
		Optional<Consultation> consultations = consulteRepository.findByReferenceFT(referenceFT);

		if (consultations.isPresent()) {
			Consultation _consul = consultations.get();
			_consul.setReference(consultation.getReference());

			return new ResponseEntity<>(consulteRepository.save(_consul), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/consultation/date")
	public ResponseEntity<List<Consultation>> getConsultationByDate(@RequestParam String login,
			@RequestParam java.sql.Date startDate, @RequestParam java.sql.Date endDate) {
		return new ResponseEntity<List<Consultation>>(
				((ConsulteRepository) consulteRepository).findByLoginAndDateRegleBetween(login, startDate, endDate),
				HttpStatus.OK);
	}
	@GetMapping("/consultation/getfacturebynumerofacture")
	public ResponseEntity<CustomResponse> getFactureByNumeroFacture(
			@RequestParam(value = "numeroFacture") String numeroFacture) {
		return ResponseEntity.ok(
				consultationImpl.getFactureByNumeroFacture(numeroFacture));
	}

}
