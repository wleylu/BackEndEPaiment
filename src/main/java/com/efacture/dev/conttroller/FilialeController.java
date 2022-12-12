package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.Filiale;
import com.efacture.dev.serviceImpl.FilialeImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class FilialeController {
	
	
	@Autowired
	private FilialeImpl agenceImpl;
	
	
	@GetMapping("/filiale/listFiliale")
    public ResponseEntity<List<Filiale>> listFiliale(){
        return ResponseEntity.ok(agenceImpl.filiale());
   	}
	
	@PostMapping("/filiale/addFiliale") 
    public ResponseEntity<Filiale> ajouterFiliale(@RequestBody Filiale a){ 
        return ResponseEntity.ok(agenceImpl.addFiliale(a));  
    }
//    @GetMapping("/type/typePaie/{nb}")
//    public ResponseEntity<TypePaiement> recherchebyNb(@PathVariable int nb){
//        return ResponseEntity.ok(typePaieImp.detailTypePaie(nb));
//    }
    @PutMapping("/filiale/updateFiliale")
	public ResponseEntity<Filiale> modifierFiliale(@RequestBody Filiale a){
		return ResponseEntity.ok(agenceImpl.updateFiliale(a));
	}


}
