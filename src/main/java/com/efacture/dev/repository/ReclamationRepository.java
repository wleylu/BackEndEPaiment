package com.efacture.dev.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.efacture.dev.model.Consultation;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.CptMarchand;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long>{
	public List<Reclamation> findByLogin(String login);
	public List<Reclamation> findByLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndReferenceContainingIgnoreCase(String login,String nom,String facturier,String reference);
	public List<Reclamation> findByDateReclamationBetweenAndLoginContainingIgnoreCaseAndNomContainingIgnoreCaseAndFacturierContainingIgnoreCaseAndReferenceContainingIgnoreCase(Date firstDate,Date lastDate,String login,String nom,String facturier,String reference);
}
