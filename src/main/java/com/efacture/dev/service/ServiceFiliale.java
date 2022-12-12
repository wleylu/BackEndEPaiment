package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.Filiale;

public interface ServiceFiliale {
	public Filiale addFiliale(Filiale filiale);
	public List<Filiale> filiale();
	public Filiale updateFiliale(Filiale filiale);

}
