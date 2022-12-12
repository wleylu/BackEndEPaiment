package com.efacture.dev.conttroller;

import java.util.List;

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


import com.efacture.dev.model.TypePaiement;
import com.efacture.dev.serviceImpl.TypePaieImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class TypePaieController {
		@Autowired
		private TypePaieImp typePaieImp;
	
		@GetMapping("/type/typePaie")
	    public ResponseEntity<List<TypePaiement>> listTypePaie(){
	        return ResponseEntity.ok(typePaieImp.TypePaie());
	   	}
		
		@PostMapping("/type/typePaieAdd") 
	    public ResponseEntity<TypePaiement> ajoutertypePaie(@RequestBody TypePaiement t){ 
	        return ResponseEntity.ok(typePaieImp.addTypePaie(t));  
	    }
	    @GetMapping("/type/typePaie/{nb}")
	    public ResponseEntity<TypePaiement> recherchebyNb(@PathVariable int nb){
	        return ResponseEntity.ok(typePaieImp.detailTypePaie(nb));
	    }
	    @PutMapping("/type/updatetypePaie")
		public ResponseEntity<TypePaiement> modifiertypePaie(@RequestBody TypePaiement t){
			return ResponseEntity.ok(typePaieImp.updateTypePaie(t));
		}
	    @GetMapping("/type/rechercheType/{type}")
	    public ResponseEntity<TypePaiement> recherche(@PathVariable int type) {
	    	return ResponseEntity.ok(typePaieImp.rechercheByType(type));
	    }
}
