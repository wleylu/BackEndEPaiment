package com.efacture.dev.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.efacture.dev.model.ConfigurationToken;

//import com.javainuse.springbootsecurity.model.ConfigurationToken;


public interface ConfigTokenRepository extends JpaRepository<ConfigurationToken, String> {
	ConfigurationToken findByLogin(String username);

}
