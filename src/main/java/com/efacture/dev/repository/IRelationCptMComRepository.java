package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.RelationCptMarchandCommission;

public interface IRelationCptMComRepository extends JpaRepository<RelationCptMarchandCommission, Long> {
	public List<RelationCptMarchandCommission> findByClient(String client);
	public RelationCptMarchandCommission findByClientAndIdCommission(String client,long idCom);
}
