package com.efacture.dev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.UserAudite;
import com.efacture.dev.model.Utilisateur;

public interface UserAuditeRespository extends JpaRepository<UserAudite, Long> {
	public List<UserAudite> findByLoginContaining(String login);
	public List<UserAudite> findByStatutContaining(String Statut);
	public List<UserAudite> findByDateBetween(Date firstDate,Date lastDate);
	public List<UserAudite> findByDateContaining(Date firstDate);
	public List<UserAudite> findByDateBetweenAndLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndStatutLike(Date firstDate,Date lastDate,String login,String nom,String statut);
	public List<UserAudite> findByLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndRoleContainingIgnoreCaseAndStatutLike(String login,String nom,String role,String statut);
	//public UserAudite findByDateConnexionAndDateDeconnexion(String dateConnexionAnd,String dateDeconnexion);
	
	
	@Query(value = "SELECT * FROM user_audite WHERE login = ?1 OR nom LIKE %?2% OR statut LIKE ?3%", nativeQuery = true)
    public List<UserAudite> rechercheNodate(String login,String nom,String statut);
}
