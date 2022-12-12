package com.efacture.dev.conttroller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.HttpResponse;
import com.efacture.dev.model.UserPresta;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.Paiement;
//import com.efacture.dev.exception.model.LoginExistException;
//import com.efacture.dev.exception.model.LoginNonTrException;
//import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.UserRepository;
//import com.efacture.dev.serviceImpl.ConsultationImpl;
//import com.efacture.dev.serviceImpl.FacturieImpl;
import com.efacture.dev.serviceImpl.UserServiceImpl;

import static org.springframework.http.HttpStatus.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private UserRepository user;

	@GetMapping("/detailUser/{login}")
	public ResponseEntity<Utilisateur> user(@PathVariable String login) {
		Utilisateur userLogin = userServiceImpl.utilisateurConnecte(login);
		return ResponseEntity.ok(userLogin);
	}
	// première connexion à l'application

	@PostMapping("/login")
	public ResponseEntity<Utilisateur> authentification(@RequestBody Utilisateur user, HttpServletRequest req) {
		// String ipAddress = req.getHeader("X-Forwarded-For");

		if (user.getLogin().equals("superAdmin") && user.getPassword().equals("admin@Admin")) {
			@SuppressWarnings("unused")
			Utilisateur usersSup=userServiceImpl.addSuperAdmin(user.getLogin(),user.getPassword());			
		}
		
		String ipAddress = req.getRemoteAddr();
		String hostuser = req.getRemoteHost() + "|" + req.getRemoteUser();
		Utilisateur userEntity = userServiceImpl.authentification(user.getLogin(), user.getPassword(), ipAddress,
				hostuser);
		// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(userEntity);
	}

	// changement de mot passe

	@PutMapping("/firstLogin")
	public ResponseEntity<?> firstAuthentification(@RequestBody Utilisateur user) {
	
		if (user.getLogin().equals("superAdmin") && user.getPassword().equals("admin@Admin")) {
			@SuppressWarnings("unused")
			Utilisateur usersSup=userServiceImpl.addSuperAdmin(user.getLogin(),user.getPassword());			
		}
		
		Utilisateur userEntity = userServiceImpl.firstAuthentification(user);

		if (userEntity.getHabilitation().equals("ROLE_PRESTATAIRE")) {
			UserPresta userPresta = new UserPresta();
			userPresta.setLogin(userEntity.getLogin());
			userPresta.setNom(userEntity.getNom());
			userPresta.setPrenom(userEntity.getPrenom());
			userPresta.setCreatedDate(new Date());
			userPresta.setExpirateToken(new Date());
			return ResponseEntity.ok(userPresta);
		}
		return ResponseEntity.ok(userEntity);
	}

	@PutMapping("/user/modifierMotPasse")
	public ResponseEntity<Utilisateur> modifierMotPasse(@RequestBody Utilisateur user) {
		Utilisateur userEntity = userServiceImpl.modificationMotPasses(user);
		// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(userEntity);
	}

	@PostMapping("/user/connexion")
	public ResponseEntity<Utilisateur> connexion(@RequestBody Utilisateur user, HttpServletRequest req) {
		String idAdresse = req.getRemoteAddr();
		String hostuser = req.getRemoteHost() + "|" + req.getRemoteUser();
		Utilisateur userEntity = userServiceImpl.connexion(user.getLogin(), user.getPassword1(), idAdresse, hostuser);
		// paie.setMontantFacture(paiement.getMontantFacture());
		return ResponseEntity.ok(userEntity);
	}

	@GetMapping("/user/utilisateur/liste")
	public ResponseEntity<List<Utilisateur>> recupererUtilisateur() {

		return ResponseEntity.ok(userServiceImpl.listeUserEntity());
	}

	@PostMapping("/user/admin/utilisateur/ajouter")
	public ResponseEntity<Utilisateur> ajouterUtilisateur(@RequestBody Utilisateur userEntity) {
		// System.out.println("Utilisateur créé avec succes");
		return ResponseEntity.ok(userServiceImpl.enregistrerUserEntity(userEntity));
	}

	@PutMapping("/user/admin/utilisateur/modifier")
	public ResponseEntity<Utilisateur> modifierUtilisateur(@RequestBody Utilisateur userEntity) {
		return ResponseEntity.ok(userServiceImpl.modifierUserEntity(userEntity));
	}

//	@PostMapping("/motDePasse/modifier")
//	public ResponseEntity<Utilisateur> modifierCptMarchand(@RequestBody Utilisateur userEntity){
//		return ResponseEntity.ok(userServiceImpl.modifierMotDePasse(userEntity));
//	}
//	@DeleteMapping("/utilisateur/supprimer/{id}")
//	public ResponseEntity<Long> supprimerUtilisateur(@PathVariable("id") Long id){
//		return ResponseEntity.ok(userServiceImpl.supprimer(id));
//	}
	@GetMapping("/deconnexion/{login}")
	public ResponseEntity<HttpResponse> deconnexion(@PathVariable String login, HttpServletRequest req) {
		String ipAdrese = req.getRemoteAddr();
		String hostuser = req.getRemoteHost() + "|" + req.getRemoteUser();
		userServiceImpl.deconnexion(login, ipAdrese, hostuser);
		return response(OK, "utilisateur deconnecté");
	}

	private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
		return new ResponseEntity<>(
				new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message),
				httpStatus);
	}

	@GetMapping("/user/rechercheUserNom/")
	public ResponseEntity<List<Utilisateur>> rechernomuser(@RequestParam(value = "nom") String nom) {
		return ResponseEntity.ok(userServiceImpl.rechercheByNom(nom));
	}

	@GetMapping("/user/rechercheUserLogin/")
	public ResponseEntity<List<Utilisateur>> rechercheloginuser(@RequestParam(value = "login") String login) {
		return ResponseEntity.ok(userServiceImpl.rechercheByLogin(login));
	}

	@GetMapping("/user/rechercheUserNomLogin")
public ResponseEntity<List<Utilisateur>> rechercheUserNomLogin(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "login") String login) {
		return ResponseEntity.ok(userServiceImpl.rechercheByNomAndLogin(nom, login));
	}
	
//	@GetMapping("/user/rechercheUserNomLogin")
//	public ResponseEntity<List<Utilisateur>> rechercheUserNomLogin(@RequestParam(value = "login") String login,
//    		@RequestParam(value = "nom") String nom){
//		return ResponseEntity.ok(userServiceImpl.rechercheByNomAndLogin(login,nom));
//    }

	@GetMapping("/user/valideusers")
	public ResponseEntity<List<Utilisateur>> valideusers(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "login") String login) {
		return ResponseEntity.ok(userServiceImpl.rechercheUsersvalide(nom, login));
	}

	@GetMapping("/rechercheUserEmail/{email}")
	public ResponseEntity<Utilisateur> recherche(@PathVariable String email) {
		return ResponseEntity.ok(userServiceImpl.rechercheByEmail(email));
	}

	@GetMapping("/user/rechercheUserTel/{tel}")
	public ResponseEntity<Utilisateur> rechercheTel(@PathVariable String tel) {
		return ResponseEntity.ok(userServiceImpl.rechercheByTel(tel));
	}

	@GetMapping("/user/getByUserByMail/{email}")
	public ResponseEntity<String> getByUserByMail(@PathVariable String email) {
		return ResponseEntity.ok(userServiceImpl.getByUserByMail(email));
	}

	@GetMapping("/user/mdp/generer")
	public ResponseEntity<String> erecupererUtilisateur() {
		return ResponseEntity.ok(userServiceImpl.generateForgotPwd());
	}

	@GetMapping("/user/motDePasseEmail/modifier")
	public ResponseEntity<Utilisateur> modifierCptMarchandE(@RequestParam(value = "email") String email) {
		return ResponseEntity.ok(userServiceImpl.modifierMotDePasseEmail(email));
	}

	@PutMapping("/user/mdpOublie/{login}")
	public ResponseEntity<Utilisateur> updateUser(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setMdpOublie(utilisateur.getMdpOublie());

			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@GetMapping("/user/utilisateur/listeUserByProfilMarchand/{login}")
	public ResponseEntity<List<Utilisateur>> listeUserProfilMarchand(@PathVariable("login") String login) {
		return ResponseEntity.ok(userServiceImpl.listeUserProfilMarchand(login));
	}

	@GetMapping("/user/utilisateur/listeUserProfilBackOffice")
	public ResponseEntity<List<Utilisateur>> listeUserProfilBackOffice() {
		return ResponseEntity.ok(userServiceImpl.listeUserProfilBackOffice());
	}

	@PutMapping("/user/pwd1/{login}")
	public ResponseEntity<Utilisateur> updateUser1(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setPassword2(utilisateur.getPassword2());

			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@PutMapping("/user/updateCompteur/{login}")
	public ResponseEntity<Utilisateur> updateNbTransaction(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setCptNbTransaction(utilisateur.getCptNbTransaction());
			_user.setCptMontant(utilisateur.getCptMontant());
			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@PutMapping("/user/mdpUpdate/{login}")
	public ResponseEntity<Utilisateur> updatemdp(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setPassword1(utilisateur.getMdpOublie());

			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@PutMapping("/tentativeConnect/{login}")
	public ResponseEntity<Utilisateur> tentative(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setTentative(utilisateur.getTentative());

			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@PutMapping("/bloqueUser/{login}")
	public ResponseEntity<Utilisateur> bloque(@PathVariable("login") String login,
			@RequestBody Utilisateur utilisateur) {
		Optional<Utilisateur> utilisateurs = user.findById(login);

		if (utilisateurs.isPresent()) {
			Utilisateur _user = utilisateurs.get();
			_user.setBloquser(utilisateur.getBloquser());

			return new ResponseEntity<>(user.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

//		
	}

	@GetMapping("/user/chiffreString")
	@ResponseBody
	public String decchiffre(@RequestParam(value = "login") String login) {
		return userServiceImpl.dechiffreTexte(login);
	}

	@GetMapping("/chiffreStringg/{login}")
	public String decchiffres(@PathVariable("login") String login) {
		return userServiceImpl.dechiffreTexte(login);
	}
	
	@GetMapping("/generermdp")
	public String generationmdp() throws Exception {
		return userServiceImpl.generatePassword();
	}
	
	@GetMapping("/decrypter")
	public String decrypte(@RequestParam(value="pass") String pass) {
		return userServiceImpl.dechiffre(pass);
	}
	
	
	 @GetMapping("/user/listeValidationBack/{agenceId}/{loginAdd}")
		public ResponseEntity<List<Utilisateur>> compteur(@PathVariable Long agenceId, @PathVariable String loginAdd) {
			return ResponseEntity.ok(userServiceImpl.getClientValid(agenceId, loginAdd));
		}
}
