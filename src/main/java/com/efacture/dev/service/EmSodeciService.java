package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.EmmissionSodeci;



public interface EmSodeciService {
	public List<EmmissionSodeci> getByIdabon(String idabon);
	public List<EmmissionSodeci> getByStatut(String statut);
	public EmmissionSodeci updateStatut(EmmissionSodeci emmissionSodeci);
	public EmmissionSodeci getByIdAbonAndPeriode(String idabon, String perfact);
}
