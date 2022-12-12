package com.efacture.dev.conttroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Reclamation;

//import com.efacture.dev.serviceImpl.ConsultationImpl;
//import com.efacture.dev.serviceImpl.FacturieImpl;
import com.efacture.dev.serviceImpl.ReclamationImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class ReclamationController {
	@Autowired
	private ReclamationImpl reclamationImpl;
	@PostMapping("/reclamation/add")
	public ResponseEntity<Reclamation> Reclamation(@RequestBody Reclamation reclamation){
		return ResponseEntity.ok(reclamationImpl.postReclamation(reclamation));
	}
	@GetMapping("/reclamation/{login}")
	public ResponseEntity<List<Reclamation>> reclamationLogin(@PathVariable String login) {
		return ResponseEntity.ok(reclamationImpl.getReclamByLogin(login));
	}
	@GetMapping("/reclamation/listeReclamantion")
	public ResponseEntity<List<Reclamation>> listeReclamantion() {
		return ResponseEntity.ok(reclamationImpl.listeReclamantion());
	}
	@GetMapping("/reclamation/rechercheReclamation")
	  public ResponseEntity<List<Reclamation>> rechercheReclamation(
			  @RequestParam(value = "firstDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			  @RequestParam(value = "lastDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate,
			  @RequestParam(value = "login") String login,
			  @RequestParam(value = "nom") String nom,
			  @RequestParam(value = "facturier") String facturier,
			  @RequestParam(value = "reference") String reference
			  
			  ){
	      return ResponseEntity.ok(reclamationImpl.rechercheReclamation(firstDate, lastDate, login, nom, facturier, reference));
	 }
	@GetMapping("/reclamation/getReclamation")
	  public ResponseEntity<List<Reclamation>> getReclamation(
			  @RequestParam(value = "login") String login,
			  @RequestParam(value = "nom") String nom,
			  @RequestParam(value = "facturier") String facturier,
			  @RequestParam(value = "reference") String reference
			  
			  ){
	      return ResponseEntity.ok(reclamationImpl.getReclamation(login, nom, facturier, reference));
	 }
}
