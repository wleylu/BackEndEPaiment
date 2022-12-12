package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
