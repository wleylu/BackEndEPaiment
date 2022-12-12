package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.EmmissionSodeci;



public interface EmSodeciRepository extends JpaRepository<EmmissionSodeci, Long> {
	public List<EmmissionSodeci> findByIdabon(String idabon);
	public List<EmmissionSodeci> findByStatut(String statut);
	public EmmissionSodeci findByIdabonAndPerfact(String idabon,String perfact);
	@Query(value = "SELECT * FROM emmission_sodeci WHERE statut = 'N' AND idabon=?1", nativeQuery = true)
	public List<EmmissionSodeci> findByIdabonner(String idabon);
}
