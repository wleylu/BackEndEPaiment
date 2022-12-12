package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.TypePaiement;

public interface TypePaiementRepository extends JpaRepository<TypePaiement, Integer> {
	public TypePaiement findByLibelle(String libelle);
	public TypePaiement findByType(int type);
}
