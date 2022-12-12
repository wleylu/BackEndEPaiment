package com.efacture.dev.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.efacture.dev.model.Mail;
//import com.caisse.projet.Model.Mail;
@Repository
public interface MailRepository extends JpaRepository<Mail, Long>{

	

}	