package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.efacture.dev.model.Facturier;
//import com.efacture.dev.model.Facturier;
import com.efacture.dev.model.Paiement;

public interface PaieRepository extends JpaRepository<Paiement, Long>{
	public Paiement findByNumCpt(String numCpt);
}
