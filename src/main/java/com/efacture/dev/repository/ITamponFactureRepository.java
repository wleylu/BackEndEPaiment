package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.TamponFacture;

public interface ITamponFactureRepository extends JpaRepository<TamponFacture, Long> {
	
}
