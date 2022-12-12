package com.efacture.dev.service;

import java.util.Date;
import java.util.List;

//import com.efacture.dev.model.CptMarchand;
import com.efacture.dev.model.ErreurGenere;

public interface ServiceErreurGenere {
	//public ErreurGenere getErreurGenerer(String login);
	public ErreurGenere enregistrerErreurGenerer(ErreurGenere erreurGenere);
	public List<ErreurGenere> listeErreurGenerer();
	public List<ErreurGenere> rechercheErreur(Date firstDate,Date lastDate,String login,String methode);
	public List<ErreurGenere> rechercheErreurs(java.sql.Date firstDate,java.sql.Date lastDate, String login, String methode);
	public List<ErreurGenere> rechercheByPeriode(Date firstDate,Date lastDate);
	public ErreurGenere modifierErreurGenerer(ErreurGenere cptMarchand);
	public List<ErreurGenere> rechercheLoginMethode(String login,String methode);
	//public Long  supprimer(Long id);
}
