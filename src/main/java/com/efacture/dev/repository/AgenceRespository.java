package com.efacture.dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.Agence;


public interface AgenceRespository extends JpaRepository<Agence, Long> {
	 @Query(value = "SELECT * FROM agence WHERE cod_agence like %?1%", nativeQuery = true)
		public Agence agenceByCodAgence(String cod_agence);


}
