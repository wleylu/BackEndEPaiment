package com.efacture.dev.conttroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.UserAudite;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.serviceImpl.UserAuditeImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class AuditConnexionController {
	@Autowired
	private UserAuditeImpl userAuditeImpl;
	
	@GetMapping("/audit/userAudit")
	public ResponseEntity<List<UserAudite>> listeAudit(){
		return ResponseEntity.ok(userAuditeImpl.listAudit()) ;
	}
	@GetMapping("/audit/rechercheLogin")
	  public ResponseEntity<List<UserAudite>> recherchelogin(@RequestParam(value = "login") String login){
	      return ResponseEntity.ok(userAuditeImpl.rechercheByLogin(login));
	 }
	@GetMapping("/audit/rechercheStatut")
	  public ResponseEntity<List<UserAudite>> rechercheStatut(@RequestParam(value = "statut") String statut){
	      return ResponseEntity.ok(userAuditeImpl.rechercheByStatut(statut));
	 }
	@GetMapping("/audit/rechercheDate")
	  public ResponseEntity<List<UserAudite>> recherchedate(@RequestParam(value = "date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date date){
	      return ResponseEntity.ok(userAuditeImpl.rechercheByDate(date));
	 }
	@GetMapping("/audit/rechercheByDateBetween")
	  public ResponseEntity<List<UserAudite>> rechercheByDateBetween(
			  @RequestParam(value = "firstDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			  @RequestParam(value = "lastDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate
			  ){
	      return ResponseEntity.ok(userAuditeImpl.rechercheByDateBetween(firstDate, lastDate));
	 }
	@GetMapping("/audit/rechercheAdit")
	  public ResponseEntity<List<UserAudite>> rechercheAdit(
			  @RequestParam(value = "firstDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date firstDate,
			  @RequestParam(value = "lastDate")  @DateTimeFormat(pattern = "yyyy-MM-dd") Date lastDate,
			  @RequestParam(value = "login") String login,
			  @RequestParam(value = "nom") String nom,
			 
			  @RequestParam(value = "statut") String statut
			  
			  ){
	      return ResponseEntity.ok(userAuditeImpl.rechercheAdit(firstDate,lastDate,login, nom, statut));
	 }
	@GetMapping("/audit/rechercheAudit")
	  public ResponseEntity<List<UserAudite>> rechercheAudit(
			  @RequestParam(value = "login") String login,
			  @RequestParam(value = "nom") String nom,
			  @RequestParam(value = "role") String role,
			  @RequestParam(value = "statut") String statut
			  ){
	      return ResponseEntity.ok(userAuditeImpl.rechercheAudit(login, nom, role, statut));
	 }
	
	@GetMapping("/audit/rechercheNodate")
	public ResponseEntity<List<UserAudite>> rechercheNodate( @RequestParam(value = "login") String login,
			  @RequestParam(value = "nom") String nom,
			 
			  @RequestParam(value = "statut") String statut){
		return ResponseEntity.ok(userAuditeImpl.rechercheNodate(login, nom, statut));
    }
	
}
