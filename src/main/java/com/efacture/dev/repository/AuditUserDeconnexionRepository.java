package com.efacture.dev.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.efacture.dev.model.UserAuditConnect;
//import com.efacture.dev.model.UserEntity;

public interface AuditUserDeconnexionRepository extends JpaRepository<UserAuditConnect, Long> {
	//@Query("SELECT ud from userdetails ud where ud.status=?1")
	//public List<UserEntity> getUserByStatus(String status);
	
	//public UserEntity findByLogin(String login);
	
}
