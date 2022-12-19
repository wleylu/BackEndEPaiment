package com.efacture.dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.efacture.dev.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "select * from transaction where login_add = :loginAdd order by id_transaction desc",nativeQuery = true)
	public List<Transaction> getListeTransaction(@Param("loginAdd") String loginAdd);
	
}
