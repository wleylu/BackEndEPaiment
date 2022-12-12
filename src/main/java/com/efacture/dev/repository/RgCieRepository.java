package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.ReglementCie;

public interface RgCieRepository extends JpaRepository<ReglementCie, Long> {
	public List<ReglementCie> findByStatut(String statut);
}
