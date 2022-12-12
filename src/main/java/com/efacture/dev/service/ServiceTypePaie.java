package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.TypePaiement;

public interface ServiceTypePaie {
	public TypePaiement addTypePaie(TypePaiement typePaiement);
	public List<TypePaiement> TypePaie();
	public TypePaiement updateTypePaie(TypePaiement typePaiement);
	public TypePaiement detailTypePaie(int typePaiement);
	public TypePaiement rechercheByType(int type);
}
