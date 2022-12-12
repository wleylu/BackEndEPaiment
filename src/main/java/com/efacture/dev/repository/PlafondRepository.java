package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.Plafond;

public interface PlafondRepository extends JpaRepository<Plafond, Long> {
	public List<Plafond> findByTypePlafondOrderByIdPlafondDesc(int type);
	public Plafond findByNombreFactureAndMontantMax(long NombreFacture,long MontantMax);
	public Plafond findByTypePlafond(int type);
}
