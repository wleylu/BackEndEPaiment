package com.efacture.dev.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, String> {
	//@Query("SELECT ud from userdetails ud where ud.status=?1")
	//public List<UserEntity> getUserByStatus(String status);
	public List<Utilisateur> findByNomContaining(String nom);
    public List<Utilisateur> findByLoginContaining(String login);
    public Utilisateur findByEmail(String email);
   
    @Query(value = "SELECT * FROM utilisateur WHERE validation=0 and login_add != :login "
    		+ " AND habilitation in ('ROLE_USER_PERSO','ROLE_USER_COM')", nativeQuery = true)
	public List<Utilisateur> findByUserProfilMarchand(@Param("login") String login);
    
    @Query(value = "SELECT * FROM utilisateur WHERE validation=0 and agence_id = ?agence and login_add != ?login "
    		+ "AND habilitation in ('ROLE_USER_PERSO','ROLE_USER_COM')", nativeQuery = true)
   	public List<Utilisateur> listeValidClient(Long agenceid, String login); 
       
    @Query(value = "SELECT * FROM utilisateur WHERE validation=0 and habilitation not in ('ROLE_USER_PERSO','ROLE_USER_COM')", nativeQuery = true)
	public List<Utilisateur> findByUserProfilBackOffice();
	//@Query("select u from UserEntity u where login = ?1")
	public List<Utilisateur> findByNomContainingIgnoreCaseAndLoginContainingIgnoreCase(String nom,String login);
	
//	 @Query(value = "select * from utilisateur where nom like :nom and login like :login", nativeQuery = true)
//	public List<Utilisateur> listeUtilisateursFiltre(@Param("nom") String nom,@Param("login") String login);
	 
	 @Query(value = "SELECT * FROM utilisateur WHERE validation = 0 AND login = ?1 OR nom like %?2%", nativeQuery = true)
	    public List<Utilisateur> listeUtilisateursFiltre(String login,String nom);
	
	public Utilisateur findByLogin(String login);
	public Utilisateur findByLoginAndPassword(String login,String password);
	public Utilisateur findByLoginAndPassword1(String login,String password1);

	
	/*
	 * public UserEntity findByLoginAndNumCpt(String login,String numCpt); public
	 * UserEntity findByNumCpt(String numCpt);
	 */
	//List<UserEntity> findByActiveAndBirthDateOrNameAndAge(String login,String numCpt, String name, int age);
	public Utilisateur findByTel(String tel);
	 @Query(value = "SELECT email FROM utilisateur WHERE email=?1", nativeQuery = true)
		public String getByUserByMail(String email);
	
	 @Query(value = "select * from utilisateur where nom like :nom and login like :login and validation = 0 ", nativeQuery = true)
	public List<Utilisateur> listeUservalide(@Param("nom") String string, @Param("login") String string2);
	 
	 @Query(value = "SELECT * FROM utilisateur WHERE validation=0"
	    		+ " AND habilitation in ('ROLE_USER_PERSO','ROLE_USER_COM')", nativeQuery = true)
	public List<Utilisateur> listeAllValid();
	 
	 @Query(value = "SELECT * FROM utilisateur WHERE agence_id = ?1 AND login_add != ?2 AND habilitation in ('ROLE_USER_PERSO','ROLE_USER_COM') ", nativeQuery = true)
	public List<Utilisateur> listeUserClientValid(Long agenceId, String loginAdd);

   
	
}
