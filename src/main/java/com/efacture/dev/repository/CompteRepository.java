package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;

public interface CompteRepository extends JpaRepository<Comptes, String> {
	
	public Comptes findByCompte(String cpt);
	public List<Comptes> findByCompteMarchand(CompteMarchand compteMarchand);
	public List<Comptes> findByCompteMarchand(String compteMarchand);
	@Query(value = "SELECT * FROM comptes WHERE code= ?1 AND statut= 1", nativeQuery = true)
	public List<Comptes>  findByCodeAndStatut(String code);
}