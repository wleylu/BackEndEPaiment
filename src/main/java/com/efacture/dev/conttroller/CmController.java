package com.efacture.dev.conttroller;

 

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.model.Commission;
//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.MessageStatut;
import com.efacture.dev.serviceImpl.CmImpl;
import com.efacture.dev.serviceImpl.TransacImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class CmController {
    
    private CmImpl cmImpl;
    private TransacImpl transacImpl;
    
    
    
    

    public CmController(CmImpl cmImpl, TransacImpl transacImpl) {
		super();
		this.cmImpl = cmImpl;
		this.transacImpl = transacImpl;
	}

	@GetMapping("/cm/admin/marchands")
    public ResponseEntity<List<CompteMarchand>> recupererCptMarchand1(){
        try {
        	return ResponseEntity.ok(cmImpl.listMarchands());
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.ok(new ArrayList<>());
		}        
    }
    
	/*
	 * @GetMapping("/cm/admin/marchands") public
	 * ResponseEntity<List<CompteMarchand>> recupererCptMarchand1(){ try { return
	 * ResponseEntity.ok(cmImpl.listMarchands()); } catch (Exception e) { // TODO:
	 * handle exception return ResponseEntity.ok(new ArrayList<>()); }
	 * 
	 * }
	 */
	/*
	 * @PostMapping("/cm/admin/marchandAdd") public ResponseEntity<CompteMarchand>
	 * ajouterCptMarchand(@RequestBody CompteMarchand c){ return
	 * ResponseEntity.ok(cmImpl.ajouterCm(c)); }
	 */
    
    
    @PostMapping("/cm/admin/marchandAdd")
    public ResponseEntity<?> ajouterCptMarchand(@RequestBody CompteMarchand c){ 
        return ResponseEntity.ok(cmImpl.addBeneficiaire(c));  
    }
    
    @PostMapping("/cm/admin/transaction")
    public ResponseEntity<?> transactionMarchand(@RequestBody CompteMarchandDTO march){      
    	return  ResponseEntity.ok(transacImpl.addTransaction(march));
    	
       //return ResponseEntity.ok(transacImpl.addTransaction(march));
    }
    
    @GetMapping("/cm/admin/benificiaire/{refTransaction}")
    public ResponseEntity<?> recherchebBeneficiare(@PathVariable(name = "refTransaction") String refTransaction){    	
       return ResponseEntity.ok(cmImpl.getBenificiaire(refTransaction));
    }
    
    @GetMapping("/cm/admin/listransations/{loginAdd}")
    public ResponseEntity<?> listeTransation(@PathVariable(name = "loginAdd") String loginAdd){    	
       return ResponseEntity.ok(cmImpl.listePaiement(loginAdd));
    }
    
    @GetMapping("/cm/admin/generateCode/{refTransaction}")
    public ResponseEntity<MessageStatut> generateCode(@PathVariable (name="refTransaction") String refTransaction ){    	
       return ResponseEntity.ok(cmImpl.generateCodeConfirmation(refTransaction));
    }
	
	  @GetMapping("/cm/admin/marchand/{racine}")
	  public  ResponseEntity<CompteMarchand> recherchebyClient(@PathVariable String
	  racine)
	  { 
		  return ResponseEntity.ok(cmImpl.getMarchand(racine));
	  }
	 
    
    @GetMapping("/cm/admin/marchandByNom")
    public ResponseEntity<List<CompteMarchand>> recherchebyNom(@RequestParam String nom){
        return ResponseEntity.ok(cmImpl.rechercheByNom(nom));
    }

     @GetMapping("/cm/admin/marchandByLogin")
      public ResponseEntity<List<CompteMarchand>> recherchebyLogin(@RequestParam String login){
         return ResponseEntity.ok(cmImpl.rechercheByLogin(login));
     
     }
    @GetMapping("/cm/admin/getByMarchandByMail/{email}")
    public ResponseEntity<String> getByMarchandByMail(@PathVariable String email){
        return ResponseEntity.ok(cmImpl.getByMarchandByMail(email));
    }
    @GetMapping("/cm/admin/recherchebyEmail/{email}")
    public ResponseEntity<CompteMarchand> recherchebyEmail(@PathVariable String email){
        return ResponseEntity.ok(cmImpl.getByEmail(email));
    }
    @GetMapping("/cm/admin/recherchebyTel/{tel}")
    public ResponseEntity<CompteMarchand> recherchebyTel(@PathVariable String tel){
        return ResponseEntity.ok(cmImpl.getByTel(tel));
    }

	/*
	 * @PutMapping("/cm/admin/marchandModif") public ResponseEntity<CompteMarchand>
	 * modifierCm(@RequestBody CompteMarchand cptMarchand){ return
	 * ResponseEntity.ok(cmImpl.modifierCm(cptMarchand)); }
	 */
    @PutMapping("/cm/admin/marchandModif")
   	public ResponseEntity<MessageStatut> modifierCm(@RequestBody CompteMarchand cptMarchand){
   		return ResponseEntity.ok(cmImpl.modifierMarchand(cptMarchand));
   	}

	/*
	 * @GetMapping("/cm/admin/consultation") public
	 * ResponseEntity<List<CompteMarchand>> recherchenomlogin(@RequestParam(value =
	 * "nom") String nom,@RequestParam(value = "login") String login ){ return
	 * ResponseEntity.ok(cmImpl.rechercheByNomAndLogin(nom,login)); }
	 */
    
    @GetMapping("/cm/admin/consultation")
    public ResponseEntity<List<CompteMarchand>> recherchenomlogin(
    		@RequestParam(value = "refTransaction") String refTransaction,
    		@RequestParam(value = "nom") String nom,
    		@RequestParam(value = "login") String login
    		){
        return ResponseEntity.ok(cmImpl.listeBenefParLogin(refTransaction,nom,login));
    }
    
    @GetMapping("/cm/admin/consultation/{login}/{nom}")
	public ResponseEntity<List<CompteMarchand>> compteur(@PathVariable String login, @PathVariable String nom) {
		return ResponseEntity.ok(cmImpl.rechercheByNomAndLogin(login, nom));
	}
    @GetMapping("/cm/admin/getcommissionbyclient/{client}")
    public ResponseEntity<List<Commission>> getCommissionByClient(@PathVariable String client){
        return ResponseEntity.ok(cmImpl.getCommissionByClient(client));
    }
}