package com.efacture.dev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Filiale;
import com.efacture.dev.repository.FilialeRespository;
import com.efacture.dev.service.ServiceFiliale;

@Service
public class FilialeImpl implements ServiceFiliale {

	@Autowired
	private FilialeRespository filialeRep;

	@Override
	public Filiale addFiliale(Filiale filiale) {
		// TODO Auto-generated method stub
		return filialeRep.save(filiale);
	}

	@Override
	public List<Filiale> filiale() {
		// TODO Auto-generated method stub
		return filialeRep.findAll();
	}

	@Override
	public Filiale updateFiliale(Filiale filiale) {
		// TODO Auto-generated method stub

		Filiale filiale2 = filialeRep.findById(filiale.getId()).get();

		if (filiale2 != null) {

			return filialeRep.save(filiale2);
		}
		return new Filiale();
	}

}
