package com.efacture.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.efacture.dev.model.MessageStatut;

public interface MessageStatutRepository extends JpaRepository<MessageStatut, String> {
	@Query(value="select libelle from message_statut where code_msg= :code",nativeQuery = true)
	public String getLibelleMessage (@Param(value = "code") String  codeMsg);

}
