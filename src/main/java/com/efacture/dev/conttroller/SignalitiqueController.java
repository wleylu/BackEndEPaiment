package com.efacture.dev.conttroller;

 

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.SignalitiqueTest;

import com.efacture.dev.serviceImpl.SignalitiqueImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class SignalitiqueController {
    @Autowired
    private SignalitiqueImpl cmImpl;
    
//    @GetMapping("/compteMarchands")
//    public ResponseEntity<List<CompteMarchand>> recupererCptMarchand(){
//        
//        return ResponseEntity.ok(cmImpl.getListeMarchands());
  // }
    @GetMapping("/admin/signalitiqueTest")
    public ResponseEntity<List<SignalitiqueTest>> recupererSignalitiqueTest(){
        try {
        	return ResponseEntity.ok(cmImpl.listMarchands());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.ok(new ArrayList<>());
		}
        
    }
    @PostMapping("/admin/addSignalitiqueTest")
    public ResponseEntity<SignalitiqueTest> ajouterSignalitiqueTest(@RequestBody SignalitiqueTest c){ 
        return ResponseEntity.ok(cmImpl.ajouterCm(c));  
    }
    @GetMapping("/admin/signalitiqueTest/{racine}")
    public ResponseEntity<SignalitiqueTest> recherchebyClient(@PathVariable String racine){
        return ResponseEntity.ok(cmImpl.getMarchand(racine));
    }
//    @GetMapping("/details/{id}")
//    public ResponseEntity<CompteMarchand> detailById(@PathVariable long id){
//        return ResponseEntity.ok(cmImpl.rechercheById(id));
//    }
//    @PutMapping("/admin/marchandModif")
//	public ResponseEntity<CompteMarchand> modifierCm(@RequestBody CompteMarchand cptMarchand){
//		return ResponseEntity.ok(cmImpl.modifierCm(cptMarchand));
//	}
//    @PostMapping("/rechercherparnom")
//    public ResponseEntity<List<CompteMarchand>> rechercheByNom(@RequestBody CompteMarchand compteMarchand){
//    	List<CompteMarchand> marchand = cmImpl.rechercheByNom(compteMarchand.getNom());
//    	return ResponseEntity.ok(marchand);
//    }
//    @GetMapping("/rechercheNom/")
//    public ResponseEntity<List<CompteMarchand>> rechernom(@RequestParam(value = "nom") String nom){
//        return ResponseEntity.ok(cmImpl.rechercheByNom(nom));
//    }
//    @GetMapping("/rechercheLogin/")
//    public ResponseEntity<List<CompteMarchand>> recherchelogin(@RequestParam(value = "login") String login){
//        return ResponseEntity.ok(cmImpl.rechercheByLogin(login));
//    }
//    @GetMapping("/admin/consultation")
//    public ResponseEntity<List<CompteMarchand>> recherchenomlogin(@RequestParam(value = "nom") 
//    String nom,@RequestParam(value = "login") String login){
//        return ResponseEntity.ok(cmImpl.rechercheByNomAndLogin(nom,login));
//    }
    /*
     * @PostMapping("/compteMarchand/rechercheByLogin") public
     * ResponseEntity<CptMarchand> rechercheByLogin(@RequestBody CptMarchand
     * cptMarchand){ CptMarchand Marchand =
     * compteMarchImpl.rechercheCptCmByLogin(cptMarchand.getNumCptCm());
     * //paie.setMontantFacture(paiement.getMontantFacture()); return
     * ResponseEntity.ok(Marchand); }
     * 
     * @PostMapping("/compteMarchand/rechercheByNumCpt") public
     * ResponseEntity<CptMarchand> rechercheByNumCpt(@RequestBody CptMarchand
     * cptMarchand){ CptMarchand Marchand =
     * compteMarchImpl.rechercheNumCptCm(cptMarchand.getNumCptCm());
     * //paie.setMontantFacture(paiement.getMontantFacture()); return
     * ResponseEntity.ok(Marchand); }
     * 
     * @PostMapping("/compteMarchand/rechercheByloginAndNumCpt") public
     * ResponseEntity<CptMarchand> rechercheByloginAndNumCpt(@RequestBody
     * CptMarchand cptMarchand){ CptMarchand Marchand =
     * compteMarchImpl.rechercheCptCmByLoginAndNumCptCm(cptMarchand.getLogin(),
     * cptMarchand.getNumCptCm());
     * //paie.setMontantFacture(paiement.getMontantFacture()); return
     * ResponseEntity.ok(Marchand); }
     * 
     * @PostMapping("/compteMarchand/ajouter") public ResponseEntity<CptMarchand>
     * ajouterCptMarchand(@RequestBody CptMarchand cptMarchand){ return
     * ResponseEntity.ok(compteMarchImpl.enregistrerCompteMarchand(cptMarchand)); }
     * 
     * @PostMapping("/compteMarchand/modifier") public ResponseEntity<CptMarchand>
     * modifierCptMarchand(@RequestBody CptMarchand cptMarchand){ return
     * ResponseEntity.ok(compteMarchImpl.modifierCptMarchand(cptMarchand)); }
     * 
     * @DeleteMapping("/compteMarchand/supprimer/{id}") public ResponseEntity<Long>
     * supprimerCptMarchand(@PathVariable("id") Long id){ return
     * ResponseEntity.ok(compteMarchImpl.supprimer(id)); }
     */
}