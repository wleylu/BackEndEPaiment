package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.Plafond;

public interface ServicePlanfond {
	public Plafond addPlafond(Plafond plafond);
	public List<Plafond> plafond();
	public List<Plafond> plafondParType(int type);
	public Plafond updatePlafond(Plafond plafond);
	public Plafond detailPlafond(Long idPlafond);
}
