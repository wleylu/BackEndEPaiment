package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.Comptes;

import com.efacture.dev.serviceImpl.compteImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class CompteControler {
	@Autowired
	private compteImpl ci;



// @RequestMapping(value = "/{code}/compte", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
// public Comptes ajouterCompte(@PathVariable(value = "code") Long code, @RequestBody Comptes compte) {
// return ci.ajouterCompte(code, compte);
// }
	@RequestMapping(value = "/{code}/addCompte", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Comptes addCompte(@PathVariable(value = "code") String code, @RequestBody Comptes compte) {
		return ci.ajouterCompte(code, compte);
	}

	@GetMapping("/comptes/list")
	public ResponseEntity<List<Comptes>> comptes() {
		return ResponseEntity.ok(ci.cpt());
	}

	@RequestMapping(value = "/compte/{id}", method = RequestMethod.GET)
	public Comptes getCompteById(@PathVariable(value = "id") String id) {
		return ci.getCompteById(id);
	}

// @PostMapping("/compte/ajouter")
// public ResponseEntity<Comptes> ajoutercompte(@RequestBody Comptes c){
// return ResponseEntity.ok(ci.saveCompte(c));
// }
	@PutMapping("/comptes/updateCompte")
	public ResponseEntity<Comptes> modifierCompte(@PathVariable String code, @RequestBody Comptes comptes) {
		return ResponseEntity.ok(ci.updateCpt(comptes));
	}

	@GetMapping("/comptes/getCompteByMarchand/{code}")
	public ResponseEntity<List<Comptes>> getCompteByMarchand(@PathVariable String code) {
		return ResponseEntity.ok(ci.getByCompteMarchand(code));
	}
	
	@GetMapping("/comptes/getCompteByStatut/{code}")
	public ResponseEntity<List<Comptes>> compteur(@PathVariable String code) { 
		return ResponseEntity.ok(ci.CompteByStatut(code));
	}
}