package com.efacture.dev.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.Commission;
import com.efacture.dev.model.RelationCptMarchandCommission;
import com.efacture.dev.repository.CommissionRepository;
import com.efacture.dev.repository.IRelationCptMComRepository;
import com.efacture.dev.service.ServiceCommission;
@Service
@Transactional
public class CommissionImpl implements ServiceCommission{
	@Autowired
	private CommissionRepository commissionRepository; 
	@Autowired
    private IRelationCptMComRepository relationCptMComRepository;
	
	@Override
	public List<Commission> listCommissions() {
		// TODO Auto-generated method stub
		return commissionRepository.findAll();
	}

	@Override
	public Commission modifierCommission(Commission com) {
		com.setDateMaj(new Date(System.currentTimeMillis()));
		Commission commission = commissionRepository.findById(com.getIdCommission()).get();
		if (commission != null) {
			if (commission.getLibelle().equals(com.getLibelle())) {
				return commissionRepository.save(com);
			}
			if (commission.getLibelle()!= com.getLibelle()) {
				if (commissionRepository.findByLibelle(com.getLibelle())==null) {
					return commissionRepository.save(com);
				}else {
					return new Commission();
				}
			}
			return commissionRepository.save(com);
		}else {
			return new Commission();
		}
	}

	@Override
	public Commission getCommissionParId(Long idCommission) {
		//Commission commission = new Commission();
		return commissionRepository.findById(idCommission).get();
		
	}

	@Override
	public Commission ajouterCommission(Commission com) {
		
		
			if (com.getIdCommission()==null) {
				if (commissionRepository.findByLibelle(com.getLibelle())==null) {
					return commissionRepository.save(com);
				}else {
					return new Commission();
				}
			}else {
				return new Commission();
			}
		
	}

	@Override
	public List<Commission> rechercheByCommission(String facturier, String libelle) {
		// TODO Auto-generated method stub
		return commissionRepository.FacturierContainingIgnoreCaseAndLibelleContainingIgnoreCase(facturier, libelle);
	}

	@Override
	public List<Commission> rechercheByCommissionfacturier(Long commissionfacturier) {
		// TODO Auto-generated method stub
		return commissionRepository.findByCommissionFacturierContaining(commissionfacturier);
		
	}

	@Override
	public Commission supprimmer(long idCommission) {
		Commission commission = commissionRepository.findByIdCommission(idCommission);
		commissionRepository.deleteById(commission.getIdCommission());
		return new Commission(commission.getIdCommission());
	}

	@Override
	public Commission getCom(int montant, String facturier) {		
		Commission coms= commissionRepository.getValeurComm(facturier,montant);		
		return coms;
	}

	public List<Commission> getCommissionByClient(String client){
		List<RelationCptMarchandCommission> relationCmCom= new ArrayList<>();
		List<Commission> commissions= new ArrayList<>();
		Commission commission=new Commission();
		try {
			relationCmCom = relationCptMComRepository.findByClient(client);
			for (RelationCptMarchandCommission relationCptMarchandCommission : relationCmCom) {
				commission=commissionRepository.findByIdCommission(relationCptMarchandCommission.getIdCommission());
				commissions.add(commission);
			}
			return commissions;
		} catch (Exception e) {
			return commissions;
		}
	}
	

	
	

	

}
