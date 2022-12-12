package com.efacture.dev.conttroller;

//import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.efacture.dev.model.Consultation;
import com.efacture.dev.model.Paiement;
import com.efacture.dev.serviceImpl.PaiementImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class PaiementController {
	@Autowired
	private PaiementImpl paiementImpl;
	@PostMapping("/paie/paiement")
	public ResponseEntity<Paiement> effectuerPaie(@RequestBody Paiement paiement){
		Paiement paie = paiementImpl.effectuerPaie(paiement.getNumCpt(), paiement.getMontantFacture(), paiement.getIntituleFacturier(),
				paiement.getFrais(), paiement.getTimbre(), paiement.getReference(), paiement.getIdentifiant(), paiement.getMontantPaye(),paiement.getDatePaiement(), paiement.getTypePaye(),  paiement.getCodeReponse());
		//paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(paie);
	}
	@GetMapping("/paie/retour/paiement/{numCpt}")
	public ResponseEntity<Paiement> retourPayement(@PathVariable String numCpt){
		return ResponseEntity.ok(paiementImpl.retourPayement(numCpt));
	}
}
