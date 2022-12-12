package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.Commission;

import com.efacture.dev.serviceImpl.CommissionImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class CommissionController {
	@Autowired
	private CommissionImpl commissionImpl;
	@PostMapping("/commission/addCommission") 
	public ResponseEntity<Commission> ajoutercompte(@RequestBody Commission c){ 
        return ResponseEntity.ok(commissionImpl.ajouterCommission(c));  
    }
	@GetMapping("/commission/list")
    public ResponseEntity<List<Commission>> listeCommission(){
        return ResponseEntity.ok(commissionImpl.listCommissions());
    }
	@GetMapping("/commission/{facturier}/{montant}")
    public ResponseEntity<Commission> getCommissionParId(@PathVariable int montant,@PathVariable String facturier ){
		
		return ResponseEntity.ok(commissionImpl.getCom(montant, facturier));
		
    }
	@DeleteMapping("/commission/supprimer/{idCommission}")
    public ResponseEntity<Commission> supprimer(@PathVariable long idCommission){
        return ResponseEntity.ok(commissionImpl.supprimmer(idCommission));
    }
	@PutMapping("/commission/modifier")
	public ResponseEntity<Commission> modifierCommission(@RequestBody Commission c){
		return ResponseEntity.ok(commissionImpl.modifierCommission(c));
	}
	@GetMapping("/commission/consulteCommission")
	  public ResponseEntity<List<Commission>> rechercheCommission(
			  @RequestParam(value = "facturier") String facturier,
			  @RequestParam(value = "libelle") String libelle
			  ){
	      return ResponseEntity.ok(commissionImpl.rechercheByCommission(facturier, libelle));
	 }
	
	@GetMapping("/commission/consulteCommission1/{commissionFacturier}")
	  public ResponseEntity<List<Commission>> recherchecom(@PathVariable long commissionFacturier){
	      return ResponseEntity.ok(commissionImpl.rechercheByCommissionfacturier(commissionFacturier));
	 }
	
	@GetMapping("/commission/getcommissionbyclient/{client}")
    public ResponseEntity<List<Commission>> getCommissionByClient(@PathVariable String client){
        return ResponseEntity.ok(commissionImpl.getCommissionByClient(client));
    }
	
}
