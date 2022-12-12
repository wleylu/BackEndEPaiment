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

import com.efacture.dev.model.Plafond;
import com.efacture.dev.serviceImpl.PlafondImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class PlafondController {
	@Autowired
	private PlafondImp plafondImpl;
	
	@GetMapping("/plafond/list")
	    public ResponseEntity<List<Plafond>> listPlafond(){
	        return ResponseEntity.ok(plafondImpl.plafond());
	   	}
	
	 @PostMapping("/plafond/plafondAdd") 
	    public ResponseEntity<Plafond> ajouterPlafond(@RequestBody Plafond p){ 
	        return ResponseEntity.ok(plafondImpl.addPlafond(p));  
	    }
	    @GetMapping("/plafond/{nb}")
	    public ResponseEntity<Plafond> recherchebyNb(@PathVariable Long nb){
	        return ResponseEntity.ok(plafondImpl.detailPlafond(nb));
	    }
	    @GetMapping("/plafond/plafondType/{nb}")
	    public ResponseEntity<List<Plafond>> plafondType(@PathVariable int nb){
	        return ResponseEntity.ok(plafondImpl.plafondParType(nb));
	    }
	    @PutMapping("/plafond/plafondUpdate")
		public ResponseEntity<Plafond> modifierPlafond(@RequestBody Plafond p){
			return ResponseEntity.ok(plafondImpl.updatePlafond(p));
		}
}
