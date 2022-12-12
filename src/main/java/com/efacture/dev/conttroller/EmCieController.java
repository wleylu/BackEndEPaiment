package com.efacture.dev.conttroller;

import java.util.ArrayList;
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

//import com.efacture.dev.model.EmissionCie;
import com.efacture.dev.model.EmmissionCie;
import com.efacture.dev.repository.EmSodeciRepository;
import com.efacture.dev.service.EmCieService;


@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class EmCieController {
	@Autowired
	private EmCieService emCieService;
	
	@Autowired
	private EmSodeciRepository emSodeciRepository;
	
	
	@GetMapping("/em/rechercheFacture/{facturier}/{idabon}")
	public ResponseEntity<List<?>> recherchebyFacture(@PathVariable String facturier,@PathVariable String idabon){
		List<?> fact = new ArrayList<>();
		
		if (facturier.equals("cie")) {
		    fact = emCieService.getByIdabon(idabon);
			}
		    else if (facturier.equals("sodeci")) {
				fact = emSodeciRepository.findByIdabonner(idabon);
		    }
		    else
		    	fact = new ArrayList<>();
		
        return ResponseEntity.ok(fact);
    }
	
	@GetMapping("/em/rechercheFactureCie/{idabon}")
	public ResponseEntity<List<EmmissionCie>> recherchebyFactureSodeci(@PathVariable String idabon){
        return ResponseEntity.ok(emCieService.getByIdabon(idabon));
    }
	@GetMapping("/em/CieGetByStatut")
	public ResponseEntity<List<EmmissionCie>> rechercheByStatut(@PathVariable String statut){
		return ResponseEntity.ok(emCieService.getByStatut(statut));
	}
	@PutMapping("/em/CieUpdateStatut")
	public ResponseEntity<EmmissionCie> updateStatuts(@RequestBody EmmissionCie emmissionCie) {
		return ResponseEntity.ok(emCieService.updateStatut(emmissionCie));
	}
	@GetMapping("/em/CieRechercheByIdabonAndPeriode")
	public ResponseEntity<EmmissionCie> rechercheByIdabonAndPeriode(
			@RequestParam(value = "idabon") String idabon,
			@RequestParam(value = "perfact") String perfact
			){
		return ResponseEntity.ok(emCieService.getByIdAbonAndPeriode(idabon, perfact));
	}
}
