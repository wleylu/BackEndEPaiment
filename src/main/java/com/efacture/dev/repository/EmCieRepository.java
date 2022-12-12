package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.EmmissionCie;

public interface EmCieRepository extends JpaRepository<EmmissionCie, Long>{

	public List<EmmissionCie> findByIdabon(String idabon);

	public List<EmmissionCie> findByStatut(String statut);

	public EmmissionCie findByIdabonAndPerfact(String idabon, String perfact);

	@Query(value = "SELECT * FROM emmission_cie WHERE statut = 'N' AND idabon=?1", nativeQuery = true)
	public List<EmmissionCie> findByIdabonner(String idabon);

}
