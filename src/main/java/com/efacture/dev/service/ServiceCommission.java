package com.efacture.dev.service;

import java.util.List;

import com.efacture.dev.model.Commission;

public interface ServiceCommission {
	public Commission getCommissionParId(Long idCommission);
	public Commission getCom(int montant,String facturier);
	public List<Commission> listCommissions();
	public Commission modifierCommission(Commission com);
	public Commission ajouterCommission(Commission com);
	public Commission supprimmer(long idCommission);
   // public List<Commission> rechercheByLibelle(String libelle);
    public List<Commission> rechercheByCommission(String facturier,String libelle);
    public List<Commission> rechercheByCommissionfacturier(Long commissionfacturier);
    

}
