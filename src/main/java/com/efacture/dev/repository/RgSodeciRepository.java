package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.ReglementSodeci;

public interface RgSodeciRepository extends JpaRepository<ReglementSodeci, Long> {
	public List<ReglementSodeci> findByStatut(String statut);
}
