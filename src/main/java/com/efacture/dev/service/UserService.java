package com.efacture.dev.service;

import java.util.List;

/*import com.efacture.dev.exception.model.LoginExistException;
import com.efacture.dev.exception.model.LoginNonTrException;
import com.efacture.dev.model.UserAuditConnect;*/

//import java.util.List;

import com.efacture.dev.model.Utilisateur;

//import com.efact.domaine.UserEntity;

public interface UserService {
	
	public Utilisateur utilisateurConnecte(String login);
	public Utilisateur getUser(String user);
	public Utilisateur authentification(String login,String password,String userIp,String userHost);
	public Utilisateur firstAuthentification(Utilisateur userEntity);
	public Utilisateur connexion(String login,String password1,String userIp,String userHost);
	public void deconnexion(String login,String userIp,String userHost);
	public Utilisateur enregistrerUserEntity(Utilisateur userEntity);
	public List<Utilisateur> listeUserEntity();
	public Utilisateur modifierUserEntity(Utilisateur userEntity);
	public String  getByUserByMail(String email);
	public List<Utilisateur> rechercheByNom(String nom);
	public List<Utilisateur> rechercheByLogin(String login);
	 public List<Utilisateur> rechercheByNomAndLogin(String nom,String login);
	 public Utilisateur rechercheByEmail(String email);
	 public Utilisateur modifierMotDePasseEmail(String email);
	 public List<Utilisateur> listeUserProfilMarchand(String login);
	 public List<Utilisateur> listeUserProfilBackOffice();
	 public List<Utilisateur> rechercheUsersvalide(String nom, String login);
	List<Utilisateur> getClientValid(Long agenceId, String loginAdd);
	
}
