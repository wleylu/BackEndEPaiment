package com.efacture.dev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.ErreurGenere;


public interface ErreurGenereRepository extends JpaRepository<ErreurGenere, Long>{
	public List<ErreurGenere> findByDateErreurBetween(Date firstDate,Date lastDate);
	public List<ErreurGenere> findByDateErreurBetweenAndLoginContainingIgnoreCaseAndMethodeContainingIgnoreCase(Date firstDate,Date lastDate,String login,String methode);
	public List<ErreurGenere> findByLoginContainingIgnoreCaseAndMethodeContainingIgnoreCase(String login,String methode);
	@Query(value = "SELECT * FROM erreur_genere WHERE BETWEEN 1? AND 2? OR methode like %3?% OR login like %4?%", nativeQuery = true)
	public List<ErreurGenere> rechercheErreurs(java.sql.Date firstDate,java.sql.Date lastDate,String login,String methode);
	
	
}
