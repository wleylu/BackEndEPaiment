package com.efacture.dev.config;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ConfigurationToken;
import com.efacture.dev.repository.ConfigTokenRepository;

//import com.javainuse.springbootsecurity.model.ConfigurationToken;
//import com.javainuse.springbootsecurity.repository.ConfigTokenRepository;

@Service
@Transactional
public class ConfigTokenService {
	
	@Autowired
	private ConfigTokenRepository configTokenRepository;
	
	public ConfigurationToken saveConfigToken(ConfigurationToken configToken) {
		return configTokenRepository.save(configToken);
	}
	public ConfigurationToken getLoginToken(String login) {
		return configTokenRepository.findByLogin(login);
	}
	public ConfigurationToken updateConfigToken(ConfigurationToken configToken) {
		ConfigurationToken confToken = getLoginToken(configToken.getLogin());
		if (confToken != null) {
			ConfigurationToken ctoken = saveConfigToken(configToken);
			return ctoken;
		}
		return new ConfigurationToken();
	}
}
