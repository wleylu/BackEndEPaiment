package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.efacture.dev.model.EmmissionSodeci;
import com.efacture.dev.service.EmSodeciService;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class EmSodeciControler {
	@Autowired
	private EmSodeciService emSodeciService;
	
	@GetMapping("/em/rechercheFactureSodeci/{idabon}")
	public ResponseEntity<List<EmmissionSodeci>> recherchebyFactureSodeci(@PathVariable String idabon){
        return ResponseEntity.ok(emSodeciService.getByIdabon(idabon));
    }
	@GetMapping("/em/getByStatut")
	public ResponseEntity<List<EmmissionSodeci>> rechercheByStatut(@PathVariable String statut){
		return ResponseEntity.ok(emSodeciService.getByStatut(statut));
	}
	@PutMapping("/em/updateStatut")
	public ResponseEntity<EmmissionSodeci> updateStatuts(@RequestBody EmmissionSodeci emmissionSodeci) {
		return ResponseEntity.ok(emSodeciService.updateStatut(emmissionSodeci));
	}
	@GetMapping("/em/rechercheByIdabonAndPeriode")
	public ResponseEntity<EmmissionSodeci> rechercheByIdabonAndPeriode(
			@RequestParam(value = "idabon") String idabon,
			@RequestParam(value = "perfact") String perfact
			){
		return ResponseEntity.ok(emSodeciService.getByIdAbonAndPeriode(idabon, perfact));
	}
}
