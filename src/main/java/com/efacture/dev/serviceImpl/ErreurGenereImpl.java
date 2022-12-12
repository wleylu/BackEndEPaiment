package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import java.util.Iterator;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.efacture.dev.model.CptMarchand;
import com.efacture.dev.model.ErreurGenere;
//import com.efacture.dev.repository.CptMRepository;
import com.efacture.dev.repository.ErreurGenereRepository;
//import com.efacture.dev.service.ServiceCptMarchand;
import com.efacture.dev.service.ServiceErreurGenere;
@Service
public class ErreurGenereImpl implements ServiceErreurGenere {
	@Autowired
	private ErreurGenereRepository erreurGenereRepository ;

	/*
	 * @Override public ErreurGenere getErreurGenerer(String login) { // TODO
	 * Auto-generated method stub return erreurGenereRepository.findByLogin(login);
	 * }
	 */

	@Override
	public ErreurGenere enregistrerErreurGenerer(ErreurGenere erreurGenere) {
		// TODO Auto-generated method stub
		return erreurGenereRepository.save(erreurGenere);
		
	}

	@Override
	public List<ErreurGenere> listeErreurGenerer() {
		// TODO Auto-generated method stub
		return erreurGenereRepository.findAll();
	}

	@Override
	public ErreurGenere modifierErreurGenerer(ErreurGenere erreurGenere) {
		// TODO Auto-generated method stub
		return erreurGenereRepository.save(erreurGenere);
	}

	@Override
	public List<ErreurGenere> rechercheErreur(Date firstDate,Date lastDate,String login,String methode) {
		try {
			return erreurGenereRepository.findByDateErreurBetweenAndLoginContainingIgnoreCaseAndMethodeContainingIgnoreCase(firstDate, lastDate,login, methode);
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	@Override
	public List<ErreurGenere> rechercheByPeriode(Date firstDate, Date lastDate) {
		// TODO Auto-generated method stub
		return erreurGenereRepository.findByDateErreurBetween(firstDate, lastDate);
	}

	@Override
	public List<ErreurGenere> rechercheErreurs(java.sql.Date firstDate,java.sql.Date lastDate, String login, String methode) {
		try {
			return erreurGenereRepository.rechercheErreurs(firstDate, lastDate, login, methode);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

	@Override
	public List<ErreurGenere> rechercheLoginMethode(String login, String methode) {
		try {
			return erreurGenereRepository.findByLoginContainingIgnoreCaseAndMethodeContainingIgnoreCase(login, methode);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}
	
	
	
	

}
