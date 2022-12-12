package com.efacture.dev.conttroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.Agence;
import com.efacture.dev.model.Consultation;
import com.efacture.dev.serviceImpl.AgenceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class AgenceController {
	
	@Autowired
	private AgenceImpl agenceImpl;
	
	
	@GetMapping("/agence/listAgence")
    public ResponseEntity<List<Agence>> listAgence(){
        return ResponseEntity.ok(agenceImpl.agence());
   	}
	
	@PostMapping("/agence/addAgence") 
    public ResponseEntity<Agence> ajouterAgence(@RequestBody Agence a){ 
        return ResponseEntity.ok(agenceImpl.addAgence(a));  
    }
//    @GetMapping("/type/typePaie/{nb}")
//    public ResponseEntity<TypePaiement> recherchebyNb(@PathVariable int nb){
//        return ResponseEntity.ok(typePaieImp.detailTypePaie(nb));
//    }
    @PutMapping("/agence/updateAgence")
	public ResponseEntity<Agence> modifierAgence(@RequestBody Agence a){
		return ResponseEntity.ok(agenceImpl.updateAgence(a));
	}

    
    @GetMapping("/agence/recherche/{id}")
	public ResponseEntity<Optional<Agence>> recherche(@PathVariable Long id) {
		return ResponseEntity.ok(agenceImpl.recherche(id));
	}
    
    @GetMapping("/agence/rechercheByCode/{cod_agence}")
	public ResponseEntity<Agence> rechercheAgence(@PathVariable String cod_agence) {
		return ResponseEntity.ok(agenceImpl.rechercheByCodeAgence(cod_agence));
	}
}
