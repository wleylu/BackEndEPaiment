package com.efacture.dev.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.Consultation;

public interface ConsulteRepository extends JpaRepository<Consultation, Long>{
	public List<Consultation> findByLogin(String login);
	public List<Consultation> findByNumeroFacture(String numeroFacture);
	public Consultation findByFacturier(String facturier);
	public Consultation findByReference(String reference);
	public Consultation findByReferenceAndFacturier(String reference, String facturier);
//	public List<Consultation> findBy(Date dateRegle, long montantDebite, String numCpt, String typeRegle, String facturier, Date dtExpFacture);
	public List<Consultation> findByLoginContaining(String login);
	public List<Consultation> findByReferenceFTContaining(String referenceFt);
	public List<Consultation> findByFacturierContaining(String facturier);
	public Consultation findByFilialeContaining(String filiale);
	public List<Consultation> findByIdentifiantContaining(String identifiant);
	public List<Consultation> findByDtExpFactureContaining(String dtExpFacture);
	public List<Consultation> findByMontantDebiteContaining(long montantDebite);
	public List<Consultation> 
	findByLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase
	(String login,String referenceFt,String facturier,String identifiant);
	public List<Consultation> 
	findByDateRegleBetweenAndLoginContainingIgnoreCaseAndReferenceFTContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndIdentifiantContainingIgnoreCase(java.util.Date firstDate,java.util.Date lastDate,String login,String referenceFt,String facturier,String identifiant);
		@Query(value = "SELECT COUNT(login) FROM consultation WHERE login= ?1 AND date_regle= ?2", nativeQuery = true)
	public Integer findByLoginCpt(String login,java.sql.Date date_regle);
	@Query(value = "SELECT COALESCE (SUM(montant_debite),0) FROM consultation WHERE login = ?1 AND date_regle=?2", nativeQuery = true)
	public Integer findByLoginMtn(String login,java.sql.Date date_regle);
	List<Consultation> findByLoginAndDateRegleBetween(String login, Date startDate, Date endDate);
	public Optional<Consultation> findByReferenceFT(String referenceFt);
	public List<Consultation> findByDateRegleBetween(java.util.Date firstDate,java.util.Date lastDate);
	//List<Consultation> findByLoginAndDateRegleBetween(String login, Date startDate, Date endDate);
}
