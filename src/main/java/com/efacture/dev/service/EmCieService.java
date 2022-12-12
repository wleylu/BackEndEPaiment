package com.efacture.dev.service;

import java.util.List;


import com.efacture.dev.model.EmmissionCie;

public interface EmCieService {
	public List<EmmissionCie> getByIdabon(String idabon);
	public List<EmmissionCie> getByStatut(String statut);
	public EmmissionCie updateStatut(EmmissionCie emmissionCie);
	public EmmissionCie getByIdAbonAndPeriode(String idabon, String perfact);

}
