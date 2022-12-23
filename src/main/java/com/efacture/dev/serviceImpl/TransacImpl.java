package com.efacture.dev.serviceImpl;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.MessageStatut;
import com.efacture.dev.model.Transaction;
import com.efacture.dev.repository.CmRepository;
import com.efacture.dev.repository.MessageStatutRepository;
import com.efacture.dev.repository.TransactionRepository;
import com.efacture.dev.service.ServiceTransaction;

@Service
public class TransacImpl implements ServiceTransaction {
	
	private MessageStatutRepository messageStatutRepository;
	private TransactionRepository transactionRepository;
	private CmRepository cmRepository;
	





	public TransacImpl(MessageStatutRepository messageStatutRepository, TransactionRepository transactionRepository,
			CmRepository cmRepository) {
		super();
		this.messageStatutRepository = messageStatutRepository;
		this.transactionRepository = transactionRepository;
		this.cmRepository = cmRepository;
	}






	@Override
	public MessageStatut addTransaction(CompteMarchandDTO marchand) {
		MessageStatut msgRetour = new MessageStatut("99", messageStatutRepository.getLibelleMessage("99"));		
		Transaction transaction = new Transaction();
		int verifMyCode= 0;
		
		
		try {		
			verifMyCode = verifieCodeConfiramtion(marchand.getRefTransaction(),marchand.getCodeTransaction(),marchand.getCodeConfirmation());
			switch (verifMyCode) {
			case 0:
				msgRetour= new MessageStatut("10", messageStatutRepository.getLibelleMessage("10"));
				break;
			case 1:
				msgRetour= new MessageStatut("09", messageStatutRepository.getLibelleMessage("09"));
				break;
			
			case 2:
				msgRetour= new MessageStatut("00", messageStatutRepository.getLibelleMessage("00"));
				break;

			default:
				msgRetour = new MessageStatut("99", messageStatutRepository.getLibelleMessage("99"));		
				break;
			}			
			if(verifMyCode == 2) {
				
				CompteMarchand m = cmRepository.getMarchandPay(marchand.getRefTransaction(), marchand.getCodeTransaction(), marchand.getCodeConfirmation());
				if (m!=null) {
					m.setEtatoper("PA");
					m.setLoginModification(marchand.getLoginMaj());
					m.setValide("S"); //paiement soldé , bénéficiaire a reçu ces fonds
					m.setDateModification(new Date());
					if(cmRepository.save(m) != null) {

						transaction.setRefTransaction(marchand.getRefTransaction());
						transaction.setCodeConfirmation(marchand.getCodeConfirmation());
						transaction.setCodeTransaction(marchand.getCodeTransaction());
						transaction.setMontant(marchand.getMontant());
						transaction.setDatOper(new Date()); 
						transaction.setStatutTraitement("00");
						transaction.setLoginAdd(marchand.getLoginAdd());				
						if (transactionRepository.save(transaction) != null) {
							
							msgRetour = new MessageStatut("00", messageStatutRepository.getLibelleMessage("00"));
						}
					}
				}				
				
			}
		} catch (Exception e) {
			msgRetour= new MessageStatut("99", messageStatutRepository.getLibelleMessage("99"));
		}
				
		return msgRetour;
	}
	
	@SuppressWarnings("unused")
	public  int verifieCodeConfiramtion(String refTransaction,String codeTransaction,String codeConfirmation) {	
		CompteMarchand cm  = new CompteMarchand();
		cm = cmRepository.findByRefTransac(refTransaction);			
		String dateValideCode = convertDate(cm.getDateValidCode());
		String  dateCurrent  = convertDate(new Date());		
		int  result= 0	;	
		int resultat = 0; //le code de confirmation n'est plus valide
				
		double tempvalide = Double.parseDouble(dateValideCode);		
		double tempCoutrant = Double.parseDouble(dateCurrent);				
		 //le code de confirmation n'est plus valide
		if (tempvalide  < tempCoutrant) {
			resultat = 0;
		}
		else 
		{
			
			try {
				result=cmRepository.getValideCode(refTransaction,codeTransaction,codeConfirmation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(result == 0 ) {
				resultat = 1; //le code de validation est incorrect
			}
			else
			{
				resultat = 2;
			}
		}
				
		return resultat;
		
	}
	
	private String convertDate(Date date1) {
		SimpleDateFormat dt= new SimpleDateFormat("yyyMMddHHmmss");	
		String result = dt.format(date1);		
		return result;
	}
	
	

}
