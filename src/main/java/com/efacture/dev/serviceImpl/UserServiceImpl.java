package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.efacture.dev.model.UserAuditConnect;
import com.efacture.dev.model.UserAudite;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.ErreurGenere;
import com.efacture.dev.model.PassInitialiseur;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.CmRepository;
import com.efacture.dev.repository.ErreurGenereRepository;
import com.efacture.dev.repository.UserRepository;
import com.efacture.dev.service.CryptageDatas;
import com.efacture.dev.service.UserService;

//import com.efact.domaine.UserEntity;
//import com.efact.repository.UserRepository;
//import com.efact.service.UserService;
@Service
@Transactional
@SuppressWarnings("unused")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAuditeImpl aut;
	@Autowired
	private ErreurGenereImpl erreurGenereImpl;

	private PasswordEncoder bcryptEncoder;

	public UserServiceImpl() {
		bcryptEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public Utilisateur utilisateurConnecte(String login) {
		// AuditUserConnexionImpl audit = new AuditUserConnexionImpl();
		Utilisateur user = new Utilisateur();
		UserAuditConnect audit = new UserAuditConnect();
		// user = userRepository.findByLogin(login);
		try {
			user = userRepository.findByLogin(login);
			if (user != null) {
//				UserAudite at= aut.ajoutAuditUser(new UserAudite(null, user.getLogin(),
//						user.getHabilitation(),"Connecté",login, login, new Date()));
			}

		} catch (Exception e) {
			ErreurGenere errg = erreurGenereImpl
					.enregistrerErreurGenerer(new ErreurGenere(new Date(), 01, login, e.getMessage()));

			// erreurRespository.save(new ErreurGenere(0, new Date(), 01, login,
			// e.getMessage()));
			// user= new UserEntity();

			// return errg;
		}

		return user;
	}

	// methode d'authentification

	@Override
	public Utilisateur authentification(String login, String password, String userip, String userHost) {
		Utilisateur user = new Utilisateur();
		CryptageDatas cryptageDatas = new CryptageDatas();
		// UserAuditConnect audit = new UserAuditConnect();
		try {
			System.out.println(cryptageDatas.cryptageData(password));
			System.out.println(cryptageDatas.decryptageData("o2i8psht8guQY81BEOvMrA=="));
			user = userRepository.findByLoginAndPassword(login, cryptageDatas.cryptageData(password));
			long dateReinitialisation = user.getDateMaj().getTime()+126018774;
			System.out.println(dateReinitialisation);
			Date dateAct = new Date();
			long dateActuelle = dateAct.getTime();
			System.out.println(dateActuelle);
			if (user != null) {
				if (dateActuelle < dateReinitialisation) {
					UserAudite at = aut.ajoutAuditUser(new UserAudite(null, user.getLogin(), user.getNom(),
							user.getPrenom(), user.getHabilitation(), "CONNECTE", userip, userHost));
				}else {
					user=null;
				}
				
			}
		} catch (Exception e) {
			ErreurGenere errg = erreurGenereImpl.enregistrerErreurGenerer(new ErreurGenere(new Date(), 01,
					"UserServiceImpl.authentification", login, e.getMessage(), "Erreur d'authentification"));
		}
		return user;
	}

	// enregistre les utilisateurs dans la base

	@Override
	public Utilisateur enregistrerUserEntity(Utilisateur userEntity) {
		String passdefaut = null;
		CryptageDatas crypt = new CryptageDatas();
		String decryptePass = null;

		try {
			passdefaut = generatePassword();
			decryptePass = crypt.decryptageData(passdefaut);
		} catch (Exception e) {
			passdefaut = null;
		}

		if (userRepository.findByLogin(userEntity.getLogin()) == null
				&& userRepository.findByEmail(userEntity.getEmail()) == null
				&& userRepository.findByTel(userEntity.getTel()) == null) {

			userEntity.setPassword(passdefaut);
			userEntity.setReinitialiser(false);
			Utilisateur utilisteurSave = userRepository.save(userEntity);
			return utilisteurSave;
		}
		return new Utilisateur();
	}

	public String generatePassword() throws Exception {
		CryptageDatas cryptageDatas = new CryptageDatas();
		///String pass = cryptageDatas.cryptageData("Efac" + RandomStringUtils.randomAlphabetic(5) + "pr");
		String pass = cryptageDatas.cryptageData("12345678");
		return pass;
	}

	// list des utilisateurs

	@Override
	public List<Utilisateur> listeUserEntity() {
		return userRepository.findAll();
	}

	// liste des profil marchand

	@Override
	public List<Utilisateur> listeUserProfilMarchand(String login) {
		Utilisateur usserConnect = userRepository.findByLogin(login);
		System.out.println(usserConnect.getHabilitation());
		List<Utilisateur> userProfilMarchand = new ArrayList<Utilisateur>();

		try {
			if (usserConnect.getHabilitation().equals("ROLE_SUPERVISEUR")) {

				userProfilMarchand = userRepository.listeAllValid();
			} else if (usserConnect.getHabilitation().equals("ROLE_HELPDESK")) {

				userProfilMarchand = userRepository.listeValidClient(usserConnect.getAgence().getId(), login);
				System.out.println(usserConnect.getAgence().getId() + login);
			} else {
				userProfilMarchand = new ArrayList<Utilisateur>();
			}

		} catch (Exception e) {
			userProfilMarchand = new ArrayList<Utilisateur>();
			return userProfilMarchand;
		}

		return userProfilMarchand;
	}

	// liste des back office
	@Override
	public List<Utilisateur> listeUserProfilBackOffice() {
		try {
			List<Utilisateur> UserProfilBackOffice = userRepository.findByUserProfilBackOffice();
			if (UserProfilBackOffice != null) {
				return UserProfilBackOffice;
			} else {

				return new ArrayList<>();
			}
		} catch (Exception e) {

			return new ArrayList<>();
		}
	}

// modification utilisateur

	@Override
	public Utilisateur modifierUserEntity(Utilisateur userEntity) {
		CryptageDatas cryptageData = new CryptageDatas();
		userEntity.setDateMaj(new Date(System.currentTimeMillis()));
		Utilisateur user = userRepository.findByLogin(userEntity.getLogin());
		System.out.println(user);

		try {
			if (user != null) {
				//user.setReinitialiser(user.getReinitialiser() == null ? false : user.getReinitialiser());
				System.out.println(userEntity.getReinitialiser() + "cest true1");
				if (userEntity.getReinitialiser() == true) {
					System.out.println(userEntity.getReinitialiser() + "cest true");
					// user.setPassword(generatePassword());
					user.setPassword1(null);
					user.setReinitialiser(true);
					user.setBloquser(0);
					user.setInit(true);
					user.setLoginMaj(userEntity.getLogin());

					return userRepository.save(user);
				} else {
					System.out.println(userEntity.getReinitialiser() + "cest false");
					return userRepository.save(userEntity);
				}
			} else {
				return new Utilisateur();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new Utilisateur();
		}

	}

// deconnecion et transabilité audit

	@Override
	public void deconnexion(String login, String userIp, String userHost) {
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		UserAuditConnect audit = new UserAuditConnect();
		user = userRepository.findByLogin(login);
		if (user != null) {
			UserAudite at = aut.ajoutAuditUser(new UserAudite(null, user.getLogin(), user.getNom(), user.getPrenom(),
					user.getHabilitation(), "DECONNECTE", userIp, userHost));
		}
	}

// liste des utlisateurs par nom

	@Override
	public List<Utilisateur> rechercheByNom(String nom) {
		// TODO Auto-generated method stub
		return userRepository.findByNomContaining(nom);
	}

	@Override
	public List<Utilisateur> rechercheByLogin(String login) {
		// TODO Auto-generated method stub
		return userRepository.findByLoginContaining(login);
	}

	@Override
	public Utilisateur getUser(String user) {
		// TODO Auto-generated method stub
		return userRepository.findByLogin(user);
	}

	@Override
	public List<Utilisateur> rechercheByNomAndLogin( String nom,String login) {
		try {
			return userRepository.findByNomContainingIgnoreCaseAndLoginContainingIgnoreCase(nom, login);
		} catch (Exception e) {
			return new ArrayList<>();
		}

	}

	@Override
	public List<Utilisateur> rechercheUsersvalide(String nom, String login) {
		try {
			return userRepository.listeUservalide("%" + nom + "%", "%" + login + "%");
		} catch (Exception e) {
			return new ArrayList<>();
		}

	}

	public Utilisateur firstAuthentification1(Utilisateur userEntity) {
		// TODO Auto-generated method stub

		Utilisateur user = new Utilisateur();
		Utilisateur users = new Utilisateur();

		user = userRepository.findByLoginAndPassword(userEntity.getLogin(), userEntity.getPassword());

		if (user != null) {
			if (user.getPassword1() == (userEntity.getPassword())) {
				users = new Utilisateur();
			} else {

				user.setDateMdp(new Date(System.currentTimeMillis()));
				user.setPassword1(bcryptEncoder.encode(userEntity.getPassword1()));
				users = userRepository.save(user);
			}
		}
		return users;

	}
	
	
	public  Utilisateur addSuperAdmin(String login, String pass) {
		// TODO Auto-generated method stub
		PassInitialiseur monPasse = new PassInitialiseur();
		CryptageDatas crypteData = new CryptageDatas();
		Utilisateur users = new Utilisateur();
		String passcrypt = null;		
		Utilisateur user = new Utilisateur();	
		
		try {			
			passcrypt = crypteData.cryptageData(pass);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		user.setLogin("superAdmin");
		user.setNom("SUPER");
		user.setPrenom("ADMINISTRATEUR");
		user.setHabilitation("ROLE_SUPER_ADMIN");
		user.setStatus(1);
		user.setValidation(1);
		user.setPassword(passcrypt);
		user.setPassword1(bcryptEncoder.encode("AdminAdmin@"));
		users = userRepository.save(user);			
		
		return users;

	}

	public Utilisateur firstAuthentification(Utilisateur userEntity) {
		// TODO Auto-generated method stub
		PassInitialiseur monPasse = new PassInitialiseur();
		CryptageDatas crypteData = new CryptageDatas();

		Utilisateur user = new Utilisateur();
		Utilisateur users = new Utilisateur();
		String passcrypt = null;

		try {
			passcrypt = crypteData.cryptageData(userEntity.getPassword());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		user = userRepository.findByLoginAndPassword(userEntity.getLogin(), passcrypt);
		System.out.println(passcrypt + "   " + user.getPassword1() + "  " + userEntity.getPassword());

		if (user != null) {
			if (user.getPassword1() == (userEntity.getPassword())) {
				users = new Utilisateur();
			} else {

				monPasse.setPass1(userEntity.getPassword1());
				monPasse.setPass2(user.getPassword2());
				monPasse.setPass3(user.getPassword3());

				boolean valiPass = monPasse.validedPass();

				if (valiPass) {
					String pass1 = null;
					try {
						pass1 = crypteData.cryptageData(userEntity.getPassword1());
					} catch (Exception e) {
						// TODO: handle exception
					}
					user.setDateMdp(new Date(System.currentTimeMillis()));
					user.setPassword1(bcryptEncoder.encode(userEntity.getPassword1()));
					user.setPassword2(pass1);
					user.setPassword3(monPasse.getPass2());
					user.setReinitialiser(false);
					users = userRepository.save(user);
				} else {
					users.setLogin(user.getLogin());
				}

			}
		}
		return users;

	}

	public Utilisateur modificationMotPasse(Utilisateur userEntity) {
		// TODO Auto-generated method stub
		Utilisateur user = new Utilisateur();
		// user =
		// userRepository.findByLoginAndPassword(userEntity.getLogin(),userEntity.getPassword());
		user = userRepository.findByLogin(userEntity.getLogin());
		// System.out.println(user);
		if (user != null) {

			if (userEntity.getPassword1().equals(user.getPassword())) {
				return new Utilisateur();
			} else { // user.setPassword(userEntity.getPassword());

				user.setPassword1(bcryptEncoder.encode(userEntity.getPassword1()));
				user.setMdpOublie(userEntity.getPassword1());
				Utilisateur users = userRepository.save(user);
				return users;
			}
		}
		return new Utilisateur();
	}

	@Override
	public Utilisateur connexion(String login, String password1, String userIp, String userHost) {
		Utilisateur user = new Utilisateur();
		// UserAuditConnect audit = new UserAuditConnect();
		try {
			user = userRepository.findByLoginAndPassword1(login, password1);
			if (user != null) {
				UserAudite at = aut.ajoutAuditUser(new UserAudite(null, user.getLogin(), user.getNom(),
						user.getPrenom(), user.getHabilitation(), "Connecté", userIp, userHost));
			}
		} catch (Exception e) {
			ErreurGenere errg = erreurGenereImpl.enregistrerErreurGenerer(new ErreurGenere(new Date(), 01,
					"UserServiceImpl.authentification", login, e.getMessage(), "Erreur d'authentification"));
		}
		return user;
	}

	public String generateForgotPwd() {
		return "{\"code\":\"Efact" + RandomStringUtils.randomAlphanumeric(7) + "re\"}";
	}

	@Override
	public Utilisateur modifierMotDePasseEmail(String email) {
// TODO Auto-generated method stub
		Utilisateur user = userRepository.findByEmail(email);
		if (user != null) {
			// user.setMdpOublie(generatePassword());
			return userRepository.save(user);
		} else {
			return new Utilisateur();
		}

	}

	@Override
	public Utilisateur rechercheByEmail(String email) {
// TODO Auto-generated method stub
		try {
			return userRepository.findByEmail(email);
		} catch (Exception e) {

			return new Utilisateur();
		}

	}

	public Utilisateur rechercheByTel(String tel) {
		// TODO Auto-generated method stub
		try {
			return userRepository.findByTel(tel);
		} catch (Exception e) {

			return new Utilisateur();
		}

	}

	@Override
	public String getByUserByMail(String email) {
		try {
			return userRepository.getByUserByMail(email);
		} catch (Exception e) {
			return null;
		}

	}

	public Utilisateur modificationMotPasses(Utilisateur userEntity) {
		// TODO Auto-generated method stub
		PassInitialiseur monPasse = new PassInitialiseur();
		CryptageDatas crypteData = new CryptageDatas();
		Utilisateur user = new Utilisateur();
		Utilisateur users = new Utilisateur();
		// user =
		// userRepository.findByLoginAndPassword(userEntity.getLogin(),userEntity.getPassword());
		user = userRepository.findByLogin(userEntity.getLogin());
		// System.out.println(user);

		if (user != null) {
			if (user.getPassword1() == (userEntity.getPassword())) {
				System.out.println("EGAUX");
				users = new Utilisateur();
			}

			else {
				System.out.println("PAS EGAUX");
				monPasse.setPass1(userEntity.getPassword1());
				monPasse.setPass2(user.getPassword2());
				monPasse.setPass3(user.getPassword3());

				boolean valiPass = monPasse.validedPass();

				if (valiPass) {
					System.out.println("PASS OK");
					String pass1 = null;
					try {
						pass1 = crypteData.cryptageData(userEntity.getPassword1());
					} catch (Exception e) {
						// TODO: handle exception
					}
					user.setDateMdp(new Date(System.currentTimeMillis()));
					user.setPassword1(bcryptEncoder.encode(userEntity.getPassword1()));
					user.setPassword2(pass1);
					user.setPassword3(monPasse.getPass2());
					users = userRepository.save(user);
				} else {
					System.out.println("PASS NOK");
					users.setLogin(user.getLogin());
				}

			}
		}

		return users;

	}

	public String dechiffreTexte(String login) {
		CryptageDatas cryptageDatas = new CryptageDatas();
		String retour = null;
		Utilisateur user = userRepository.findByLogin(login);
		System.out.println(user);
		if (user != null) {
			try {
				retour = cryptageDatas.decryptageData(user.getPassword());
				System.out.println(retour + "MDP");

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return retour;
	}

	public String dechiffre(String pass) {
		CryptageDatas cryptageDatas = new CryptageDatas();
		String retour = null;

		try {
			retour = cryptageDatas.decryptageData(pass);
			System.out.println(retour + "MDP");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return retour;
	}

	@Override
	public List<Utilisateur> getClientValid(Long agenceId, String loginAdd) {
		Utilisateur usserConnect = userRepository.findByLogin(loginAdd);
		System.out.println(usserConnect.getHabilitation());
		List<Utilisateur> userProfilMarchand = new ArrayList<Utilisateur>();
		try {
			if (usserConnect.getHabilitation().equals("ROLE_HELPDESK")) {
			return userRepository.listeUserClientValid(agenceId,loginAdd);
			}
			else if (usserConnect.getHabilitation().equals("ROLE_SUPERVISEUR")) {

				userProfilMarchand = userRepository.listeAllValid();
			}
			else {
				userProfilMarchand = new ArrayList<Utilisateur>();
			}
		} catch (Exception e) {
			userProfilMarchand = new ArrayList<Utilisateur>();
			return userProfilMarchand;
		}
		
		return userProfilMarchand;
	}
	
	
//		@Override
//	public List<Utilisateur> listeUserProfilMarchand(String login) {
//		Utilisateur usserConnect = userRepository.findByLogin(login);
//		System.out.println(usserConnect.getHabilitation());
//		List<Utilisateur> userProfilMarchand = new ArrayList<Utilisateur>();
//
//		try {
//			if (usserConnect.getHabilitation().equals("ROLE_SUPERVISEUR")) {
//
//				userProfilMarchand = userRepository.listeAllValid();
//			} else if (usserConnect.getHabilitation().equals("ROLE_HELPDESK")) {
//
//				userProfilMarchand = userRepository.listeValidClient(usserConnect.getAgence().getId(), login);
//				System.out.println(usserConnect.getAgence().getId()+ login);
//			} else {
//				userProfilMarchand = new ArrayList<Utilisateur>();
//			}
//
//		} catch (Exception e) {
//			userProfilMarchand = new ArrayList<Utilisateur>();
//			return userProfilMarchand;
//		}
//
//		return userProfilMarchand;
//	}

}
