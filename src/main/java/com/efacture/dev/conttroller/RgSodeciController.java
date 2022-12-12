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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.ReglementSodeci;
import com.efacture.dev.serviceImpl.RgSodeciServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class RgSodeciController {
	@Autowired
	private RgSodeciServiceImpl rgSodeciServiceImpl;
	
	@PostMapping("/rg/addRgSodeci")
	public ResponseEntity<ReglementSodeci> addRgSodeci(@RequestBody ReglementSodeci reglementSodeci) {
		return ResponseEntity.ok(rgSodeciServiceImpl.addReglement(reglementSodeci));
	}
	
	@PutMapping("/rg/updateRgSodeci")
	public ResponseEntity<ReglementSodeci> updateRgSodeci(@RequestBody ReglementSodeci reglementSodeci){
		return ResponseEntity.ok(rgSodeciServiceImpl.updateReglement(reglementSodeci));
	}
	
	@GetMapping("/rg/listRgSodeci")
	public ResponseEntity<List<ReglementSodeci>> listRgSodeci(){
		return ResponseEntity.ok(rgSodeciServiceImpl.listeReglement());
	}
	
	@GetMapping("/rg/getRgSodeciByStatut")
	public ResponseEntity<List<ReglementSodeci>> getRgSodeciByStatut(@RequestParam String statut){
		return ResponseEntity.ok(rgSodeciServiceImpl.getReglementByStatut(statut));
	}
}
