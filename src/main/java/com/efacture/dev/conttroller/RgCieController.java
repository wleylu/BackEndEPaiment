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

import com.efacture.dev.model.ReglementCie;
import com.efacture.dev.serviceImpl.RgCieServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class RgCieController {
	@Autowired
	private RgCieServiceImpl rgCieServiceImpl;

	@PostMapping("/rg/addRgCie")
	public ResponseEntity<ReglementCie> addRgCie(@RequestBody ReglementCie reglementCie) {
		return ResponseEntity.ok(rgCieServiceImpl.addReglement(reglementCie));
	}

	@PutMapping("/rg/updateRgCie")
	public ResponseEntity<ReglementCie> updateRgCie(@RequestBody ReglementCie reglementCie) {
		return ResponseEntity.ok(rgCieServiceImpl.updateReglement(reglementCie));
	}

	@GetMapping("/rg/listRgCie")
	public ResponseEntity<List<ReglementCie>> listRgCie() {
		return ResponseEntity.ok(rgCieServiceImpl.listeReglement());
	}

	@GetMapping("/rg/getRgCieByStatut")
	public ResponseEntity<List<ReglementCie>> getRgCieByStatut(@RequestParam String statut) {
		return ResponseEntity.ok(rgCieServiceImpl.getReglementByStatut(statut));
	}
}