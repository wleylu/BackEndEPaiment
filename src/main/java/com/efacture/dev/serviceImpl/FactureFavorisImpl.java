package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.CustomResponse;
import com.efacture.dev.model.FactureFavoris;
import com.efacture.dev.model.Vfacturier;
import com.efacture.dev.repository.IFactureFavorisRepository;
import com.efacture.dev.repository.UserRepository;
import com.efacture.dev.repository.VfacturierRepository;
import com.efacture.dev.service.IServiceFactureFavoris;

@Service
public class FactureFavorisImpl implements IServiceFactureFavoris {
	@Autowired
	public IFactureFavorisRepository factureFavorisRepository;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public VfacturierRepository vfacturierRepository;
	/*************Cette methode permet au client******************* 
	 ************d'ajouter,modifier et desactiver une facture en favoris******************
	 ************************************************************/
	@Override
	public CustomResponse saveFactureFavoris(FactureFavoris factureFavoris) {
		CustomResponse customResponse = new CustomResponse();
		
		try {
			/**************************Ajout et modification d'une facture favoris****************************/
			if (factureFavoris.getAction()) {
				/**************************Ajouter une facture favoris****************************/
				if (factureFavoris.getId()==0) {
					FactureFavoris newFactureFavoris= new FactureFavoris();
					newFactureFavoris.setTypeFacture(factureFavoris.getTypeFacture());
					newFactureFavoris.setReference(factureFavoris.getReference());
					newFactureFavoris.setNomComplet(factureFavoris.getNomComplet());
					newFactureFavoris.setIdClient(factureFavoris.getIdClient());
					factureFavorisRepository.save(newFactureFavoris);
					customResponse.code=0;
					customResponse.message="Facture favoris ajouté avec succes";
					customResponse.generateId=newFactureFavoris.getId();
				} 
				/**************************Modifier une facture favoris****************************/
				else {
					FactureFavoris exitFactureFavoris = factureFavorisRepository.findById(factureFavoris.getId()).get();
					exitFactureFavoris.setTypeFacture(factureFavoris.getTypeFacture());
					exitFactureFavoris.setReference(factureFavoris.getReference());
					exitFactureFavoris.setNomComplet(factureFavoris.getNomComplet());
					exitFactureFavoris.setDateUpdate(new Date(System.currentTimeMillis()));
					factureFavorisRepository.save(exitFactureFavoris);
					customResponse.code=0;
					customResponse.message="Facture favoris modifié avec succes";
					customResponse.generateId=exitFactureFavoris.getId();
				}
			} 
			/**************************Statut facture favoris****************************/
			else {
				FactureFavoris statutFactureFavoris = factureFavorisRepository.findById(factureFavoris.getId()).get();
				/**************************desactiver une facture favoris****************************/
				if (statutFactureFavoris.isStatut()==true) {
					statutFactureFavoris.setStatut(false);
					factureFavorisRepository.save(statutFactureFavoris);
					customResponse.code=0;
					customResponse.message="Facture favoris desactivé avec succes";
					customResponse.generateId=statutFactureFavoris.getId();
				} 
				/**************************Activer une facture favoris****************************/
				else {
					statutFactureFavoris.setStatut(true);
					factureFavorisRepository.save(statutFactureFavoris);
					customResponse.code=0;
					customResponse.message="Facture favoris activé avec succes";
					customResponse.generateId=statutFactureFavoris.getId();
				}
			}
		} catch (Exception e) {
			customResponse.code=-1;
			customResponse.message="Echec d'enregistrement de facture favoris "+e;
		}
		return customResponse;
	}
	/*************Cette methode permet au client******************* 
	 ************de visualiser la liste des facture favoris en fonction du statut******************
	 ************************************************************/
	@Override
	public List<FactureFavoris> listFactureFavoris(String idClient, boolean statut) {
		List<FactureFavoris> factureFavoris = new ArrayList<>();
		List<FactureFavoris> listfactureFavoris = new ArrayList<>();
		try {
			factureFavoris = factureFavorisRepository.findByIdClientAndStatut(idClient,statut);
			for (FactureFavoris factureFavori : factureFavoris) {
				factureFavori.setUtilisateur(userRepository.findByLogin(idClient));
				factureFavori.setVfacturier(vfacturierRepository.findById(factureFavori.getTypeFacture()).get());
				listfactureFavoris.add(factureFavori);
			}
		} catch (Exception e) {
			factureFavoris = new ArrayList<>();
			System.out.println("Echecs" +e);
		}
		return listfactureFavoris;
	}

}
