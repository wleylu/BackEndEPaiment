package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CustomResponse;
import com.efacture.dev.model.FactureFavoris;
import com.efacture.dev.serviceImpl.FactureFavorisImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class FactureFavorisController {
	@Autowired
	public FactureFavorisImpl factureFavorisImpl;
	/*************Cette API permet au client******************* 
	 ************d'ajouter,modifier et desactiver une facture en favoris******************
	 ************************************************************/
	@PostMapping("/facturefavoris/savefacturefavoris") 
	public CustomResponse saveFactureFavoris(@RequestBody FactureFavoris factureFavoris) {
		return factureFavorisImpl.saveFactureFavoris(factureFavoris);
	} 
	
	/*************Cette methode permet au client******************* 
	 ************de visualiser la liste des facture favoris actif******************
	 ************************************************************/
	@GetMapping("/facturefavoris/listfacturefavoris")
	public List<FactureFavoris> listFactureFavoris(
			@RequestParam(value = "client") String idClient,
			@RequestParam(value = "statut") boolean statut
			){
		return factureFavorisImpl.listFactureFavoris(idClient,statut);
	}
}
