package com.efacture.dev.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.efacture.dev.model.Facturier;

public interface FacturieRepository extends JpaRepository<Facturier, Long>{
	
	Optional<Facturier> findByName(String name);
}
