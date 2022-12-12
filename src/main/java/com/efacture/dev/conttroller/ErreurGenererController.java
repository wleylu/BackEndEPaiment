package com.efacture.dev.conttroller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.efacture.dev.model.ErreurGenere;
import com.efacture.dev.serviceImpl.ErreurGenereImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class ErreurGenererController {
	@Autowired
	private ErreurGenereImpl erreurGenereImpl;
	@GetMapping("/erreurs/list")
    public ResponseEntity<List<ErreurGenere>> listeErreurGenerer(){
        
        return ResponseEntity.ok(erreurGenereImpl.listeErreurGenerer());
    }
	@PostMapping("/erreurs/addErreurs") 
    public ResponseEntity<ErreurGenere> ajouterErreurs(@RequestBody ErreurGenere e){ 
        return ResponseEntity.ok(erreurGenereImpl.enregistrerErreurGenerer(e));  
    }
	@GetMapping("/erreurs/rechercheByPeriode")
	  public ResponseEntity<List<ErreurGenere>> rechercheByPeriode(
			  @RequestParam(value = "firstDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			  @RequestParam(value = "lastDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate
			  ){
	      return ResponseEntity.ok(erreurGenereImpl.rechercheByPeriode(firstDate, lastDate));
	 }
	@GetMapping("/erreurs/rechercheErreur")
    public ResponseEntity<List<ErreurGenere>> rechercheErreur(
    		@RequestParam(value = "firstDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			@RequestParam(value = "lastDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate,
    		@RequestParam(value = "login") String login,
    		@RequestParam(value = "methode") String methode
    		){
		return ResponseEntity.ok(erreurGenereImpl.rechercheErreur(firstDate,lastDate,login, methode));
    }
	@GetMapping("/erreurs/rechercheLoginMethode")
    public ResponseEntity<List<ErreurGenere>> rechercheErreurs(
    		@RequestParam(value = "login") String login,
    		@RequestParam(value = "methode") String methode
    		){
		return ResponseEntity.ok(erreurGenereImpl.rechercheLoginMethode(login, methode));
    }
	@GetMapping("/erreurs/rechercheErreurs")
    public ResponseEntity<List<ErreurGenere>> rechercheErreurs(
    		@RequestParam(value = "firstDate")   java.sql.Date firstDate,
			@RequestParam(value = "lastDate")   java.sql.Date lastDate,
    		@RequestParam(value = "login") String login,
    		@RequestParam(value = "methode") String methode
    		){
		return ResponseEntity.ok(erreurGenereImpl.rechercheErreurs(firstDate,lastDate,login, methode));
    }
}
