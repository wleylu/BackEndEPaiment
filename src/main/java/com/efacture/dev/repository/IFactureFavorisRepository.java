package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.FactureFavoris;

public interface IFactureFavorisRepository extends JpaRepository<FactureFavoris, Long> {
	public List<FactureFavoris> findByIdClientAndStatut(String idClient, boolean statut);
}
