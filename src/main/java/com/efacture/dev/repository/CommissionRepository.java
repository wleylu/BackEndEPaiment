package com.efacture.dev.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.efacture.dev.model.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Long>  {
	public Commission findByIdCommission(Long id);
	//public List<Commission> findByLibelle(String libelle);
	public List<Commission> FacturierContainingIgnoreCaseAndLibelleContainingIgnoreCase(String facturier,String libelle);
	public List<Commission> findByCommissionFacturierContaining(Long commissionFacturier);
	public Commission findByLibelle(String libelle);
	@Query(value="select * from commission f where f.facturier= :facturier and f.mnt_seuil <= :montant and  f.mnt_max >= :montant",nativeQuery=true)
	public Commission getValeurComm(@Param("facturier") String facturier,@Param("montant") int montant);
	
	
}

