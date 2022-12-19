package com.efacture.dev.serviceImpl;

 

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.MapperDTO.MapperDTO;
import com.efacture.dev.model.Commission;
import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.model.Comptes;
import com.efacture.dev.model.Mail;
import com.efacture.dev.model.MessageStatut;
import com.efacture.dev.model.RelationCptMarchandCommission;
import com.efacture.dev.model.Transaction;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.repository.CmRepository;
import com.efacture.dev.repository.CommissionRepository;
import com.efacture.dev.repository.IRelationCptMComRepository;
import com.efacture.dev.repository.MessageStatutRepository;
import com.efacture.dev.repository.TransactionRepository;
import com.efacture.dev.service.ServiceCm;

@Service
@Transactional
public class CmImpl implements ServiceCm {
	

	private UserServiceImpl user; 
	
	private MessageStatutRepository msgRepository;
    private CmRepository cmRepository;
    private IRelationCptMComRepository relationCptMComRepository;
	private ErreurGenereImpl erreurGenereImpl;
    private CommissionRepository reposistoryCommission; 
    private MapperDTO mapperDTO;   
	private SendMailService serviceMail;
	private TransactionRepository tranRepository;
    
    
   
    public CmImpl(UserServiceImpl user, MessageStatutRepository msgRepository, CmRepository cmRepository,
			IRelationCptMComRepository relationCptMComRepository, ErreurGenereImpl erreurGenereImpl,
			CommissionRepository reposistoryCommission,MapperDTO mapperDTO,SendMailService serviceMail,
			TransactionRepository tranRepository) {
		super();
		this.user = user;
		this.msgRepository = msgRepository;
		this.cmRepository = cmRepository;
		this.relationCptMComRepository = relationCptMComRepository;
		this.erreurGenereImpl = erreurGenereImpl;
		this.reposistoryCommission = reposistoryCommission;
		this.mapperDTO = mapperDTO;
		this.serviceMail = serviceMail;
		this.tranRepository = tranRepository;
	}

	@SuppressWarnings("unused")
	public CompteMarchand ajouterCm(CompteMarchand c) {
		//Commission com = reposistoryCommission.findById(c.getCommission().getIdCommission()).get();
		Comptes cpt = null;     //c.getComptes().get(0);
		CompteMarchand marchand = new CompteMarchand();
		CompteMarchand march = new CompteMarchand();
		Utilisateur userLogin = user.getUser(c.getLoginAdd());
		
		try {
			System.out.println(c.getClient());
			CompteMarchand m = cmRepository.findByClient(c.getClient());
			
			System.out.println(m);
			
			
			if (cmRepository.findByClient(c.getClient()) == null && cmRepository.findByEmail(c.getEmail())==null
					&& cmRepository.findByTel(c.getTel())==null){
				System.out.println("Nicaise");
				marchand.setClient(c.getClient());
				marchand.setSexe(c.getSexe());
				marchand.setNomPrenom(c.getNomPrenom());
				marchand.setNom(c.getNom());
				marchand.setPrenom(c.getPrenom());
				marchand.setDateNais(c.getDateNais());
				marchand.setStatut(c.getStatut());
				marchand.setTypeCpt(c.getTypeCpt());
				marchand.setNumCpt(c.getSexe());
				marchand.setNumCptContribuable(c.getNumCptContribuable());
				marchand.setRegCrc(c.getRegCrc());
				marchand.setOptionCm(c.getOptionCm());
				marchand.setRaisonSocial(c.getRaisonSocial());
				marchand.setAgec(c.getAgec());
				marchand.setTel(c.getTel());
				marchand.setPieceId(c.getPieceId());
				marchand.setDateExpir(c.getDateExpir());
				marchand.setDateDelivr(c.getDateDelivr());
				marchand.setEmail(c.getEmail());
				marchand.setLogin(c.getLogin());
				marchand.setAdCm(c.getAdCm());
				marchand.setDateModification(c.getDateModification());
				//marchand.setCommission(com);
				marchand.setLoginAdd(c.getLoginAdd());
				marchand.setLoginModification(c.getLoginModification());
				/*
				 * for(Commission commission : c.getCommission()) {
				 * System.out.println("test commission :" +commission.getIdCommission()); } for
				 * (Commission commission : c.getCommission()) { RelationCptMarchandCommission
				 * relationCptMarchandCommission = new RelationCptMarchandCommission();
				 * relationCptMarchandCommission.setIdCommission(commission.getIdCommission());
				 * relationCptMarchandCommission.setClient(c.getClient());
				 * relationCptMComRepository.save(relationCptMarchandCommission); }
				 */
				
				
				march=cmRepository.save(marchand);
				
				/*
				 * System.out.println(march); if (!c.getComptes().isEmpty()) { for(Comptes
				 * cp:c.getComptes()){ cpt = new Comptes(cp.getCompte(), cp.getAgence(),
				 * cp.getNcg(), cp.getLibNcg(), cp.getCoddci(), cp.getExpl(), cp.getStatut(),
				 * marchand); compte.save(cpt); } }else { for(Comptes cp:c.getComptesInactif()){
				 * cpt = new Comptes(cp.getCompte(), cp.getAgence(), cp.getNcg(),
				 * cp.getLibNcg(), cp.getCoddci(), cp.getExpl(), 0, marchand); compte.save(cpt);
				 * } }
				 */
				//cpt.setCompteMarchand(marchand);
				return march;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			System.out.println(e);
			return new CompteMarchand();
		}
	}

    @Override
    public List<CompteMarchand> listMarchands() {
    	try {
    		return cmRepository.findAll();
		} catch (Exception e) {
			return new ArrayList<>();
		} 
    }
    
	/*
	 * @Override public List<CompteMarchand> listMarchands() { try { return
	 * cmRepository.findAll(); } catch (Exception e) { return new ArrayList<>(); } }
	 */
    
    
    
    @Override
    public MessageStatut addBeneficiaire(CompteMarchand marchand) {
    	
		MessageStatut msgRetour= new MessageStatut();
		marchand.setValide("N");
		marchand.setEtatoper("NP"); //Non payé ===PA: Payé
		
		if (cmRepository.findByRefTransac(marchand.getRefTransaction()) != null) {
			msgRetour.setCodeMsg("03");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("03"));			
			return msgRetour;
		}
		else if (cmRepository.findByCodeTransaction(marchand.getCodeTransaction()) != null) {
			msgRetour.setCodeMsg("04");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("04"));			
			return msgRetour;
		} else if (cmRepository.findByTel(marchand.getTel()) != null) {
			msgRetour.setCodeMsg("05");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("05"));
			
			return msgRetour;
		} else if (cmRepository.findByEmail(marchand.getEmail()) != null) {
			msgRetour.setCodeMsg("06");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("06"));
			
			return msgRetour;
		}
		else
		{
			msgRetour= new MessageStatut();
		}
		
		
		if (cmRepository.save(marchand) != null) {
			msgRetour.setCodeMsg("00");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("00"));
		}
		else
		{
			msgRetour.setCodeMsg("01");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("01"));
		}
		return msgRetour;
	}
    
	
	  @Override public CompteMarchand getMarchand(String client) {
	  
	  System.out.println("141010060".substring(3, 8)); try { CompteMarchand
	  compteMarchand = cmRepository.findById(client).get();
	  
	  if (compteMarchand != null) { return compteMarchand;
	  
	  } else { return new CompteMarchand(); }
	  
	  
	  } catch (Exception e) { return new CompteMarchand(); }
	  
	  }
	 
    
    
    @Override
    public CompteMarchandDTO getBenificiaire(String refTransaction) {
    	try {
    		CompteMarchand compteMarchand = cmRepository.findByRefTransac(refTransaction);  		
    	
    		
			if (compteMarchand != null) {
		        return mapperDTO.fromCompteMarchandToDTO(compteMarchand);
		      
			} else {
				return new CompteMarchandDTO();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return new CompteMarchandDTO();
		}
    	
    }
    
    
    @Override
	public MessageStatut modifierMarchand(CompteMarchand cptMarchand) {
		cptMarchand.setDateModification(new Date(System.currentTimeMillis()));		
		MessageStatut msgRetour = new MessageStatut();
		
		CompteMarchand march = cmRepository.findById(cptMarchand.getId());
		
		try {
			
			if (march != null) {
				
				if (!march.getRefTransaction().equals(march.getRefTransaction())) {
					if (cmRepository.findByRefTransac(cptMarchand.getRefTransaction()) != null) {
					
						msgRetour.setCodeMsg("03");
						msgRetour.setLibelle(msgRepository.getLibelleMessage("03"));			
						return msgRetour;
					}
					
				}
				else if (!march.getCodeTransaction().equals(cptMarchand.getCodeTransaction()))
				{
					if (cmRepository.findByCodeTransaction(cptMarchand.getCodeTransaction()) != null) {
						msgRetour.setCodeMsg("04");
						msgRetour.setLibelle(msgRepository.getLibelleMessage("04"));			
						return msgRetour;
					}
				}
				else if (!march.getTel().equals(cptMarchand.getTel())) {
					if (cmRepository.findByTel(cptMarchand.getTel()) != null) {
						msgRetour.setCodeMsg("05");
						msgRetour.setLibelle(msgRepository.getLibelleMessage("05"));
						
						return msgRetour;
					}
				}
				else if(!march.getEmail().equals(cptMarchand.getEmail())) {
					if (cmRepository.findByEmail(cptMarchand.getEmail()) != null) {
						msgRetour.setCodeMsg("06");
						msgRetour.setLibelle(msgRepository.getLibelleMessage("06"));
						
						return msgRetour;
					}
					
				}
				else
				{
					msgRetour= new MessageStatut();
				}			
				
					if (cmRepository.save(cptMarchand) != null) {
						msgRetour.setCodeMsg("00");
						msgRetour.setLibelle(msgRepository.getLibelleMessage("00"));
					}
			}
			else
			{
				msgRetour.setCodeMsg("07");
				msgRetour.setLibelle(msgRepository.getLibelleMessage("07"));
			}
			
		
		} catch (Exception e) {
			msgRetour.setCodeMsg("01");
			msgRetour.setLibelle(msgRepository.getLibelleMessage("01"));
		}
		
		return msgRetour;
	}

	@Override
	public CompteMarchand modifierCm(CompteMarchand cptMarchand) {
		cptMarchand.setDateModification(new Date(System.currentTimeMillis()));
		CompteMarchand marchands = new CompteMarchand();
		
		try {
			CompteMarchand cpt = cmRepository.findByClient(cptMarchand.getClient());
			//Utilisateur uti = user.getUser(cptMarchand.getLoginModification());
			if (cpt!=null) {
				List<RelationCptMarchandCommission> relationCmComs=relationCptMComRepository.findByClient(cptMarchand.getClient());
				relationCptMComRepository.deleteAll(relationCmComs);
				/*
				 * for (Commission commission : cptMarchand.getCommission()) {
				 * RelationCptMarchandCommission relationCmCom = new
				 * RelationCptMarchandCommission();
				 * relationCmCom.setClient(cptMarchand.getClient());
				 * relationCmCom.setIdCommission(commission.getIdCommission());
				 * relationCptMComRepository.save(relationCmCom); }
				 */
				return cmRepository.save(cptMarchand);
			}else {
			
				return marchands;
			}
		} catch (Exception e) {
			return marchands;
		}
	}

	@Override
	public List<CompteMarchand> rechercheByNomAndLogin(String nom, String refTransaction) {
		try {
			return cmRepository.findByNomContainingIgnoreCaseAndRefTransactionContainingIgnoreCase(nom, refTransaction);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}
	
	
	@Override
	public List<CompteMarchand> listeBenefParLogin(String refTransaction,String nom, String login ) {
		try {
			return cmRepository.listeComptesMarchands(nom, refTransaction,login);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}
	
	
	
//	@Override
//	public List<CompteMarchand> rechercheByNomAndLogin(String login, String nom) {
//		try {
//			return cmRepository.listeComptesMarchands(login,nom);
//		} catch (Exception e) {
//			return new ArrayList<>();
//		}
//		
//	}

	@Override
	public List<CompteMarchand> rechercheByLogin(String login) {
		try {
			return cmRepository.findByLogin(login);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}
	
	@Override
	public List<CompteMarchand> rechercheByNom(String nom) {
		try {
			return cmRepository.findByNomContaining(nom);
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
	}

	@Override
	public CompteMarchand getByEmail(String email) {
		CompteMarchand existeEmail=cmRepository.findByEmail(email);
		try {
			if (existeEmail != null) {
				return existeEmail;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
	}
	public CompteMarchand getByTel(String tel) {
		CompteMarchand existeTel=cmRepository.findByTel(tel);
		try {
			if (existeTel != null) {
				return existeTel;
			}else {
				return new CompteMarchand();
			}
		} catch (Exception e) {
			return new CompteMarchand();
		}
	}

	@Override
	public String getByMarchandByMail(String email) {
		try {
			return cmRepository.getByMarchandByMail(email);
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Commission> getCommissionByClient(String client){
		List<RelationCptMarchandCommission> relationCmCom= new ArrayList<>();
		List<Commission> commissions= new ArrayList<>();
		Commission commission=new Commission();
		try {
			relationCmCom = relationCptMComRepository.findByClient(client);
			for (RelationCptMarchandCommission relationCptMarchandCommission : relationCmCom) {
				commission=reposistoryCommission.findByIdCommission(relationCptMarchandCommission.getIdCommission());
				commissions.add(commission);
			}
			return commissions;
		} catch (Exception e) {
			return commissions;
		}
	}
	

	
	@Override
	public MessageStatut generateCodeConfirmation(String refTransaction) {
	
		CompteMarchand marchand = new CompteMarchand();
		String code = RandomStringUtils.randomNumeric(4);
		Mail mail = new Mail();
		long msgStatus = 0;
		MessageStatut retourTrt = new MessageStatut("01", msgRepository.getLibelleMessage("01"));
		Date mdate =new Date(System.currentTimeMillis()+300000);
		
		try {
			marchand = cmRepository.findByRefTransac(refTransaction);
			
			  if (marchand != null) 
			  {
				 marchand.setCodeConfirmation(code);
				 marchand.setDateValidCode(mdate); 
				 String message= "Bonjour M/Mme/Mlle "+marchand.getNom()+",\n"
						 +"Votre code de confirmation est le suivant : "+code+"\n"
						 +"Nous vous prions de ne communiquer se code à personne, il est strictement privé et confidentiel.\n"
						 +"Merci pour votre compréhension";
				 
				 mail.setDestinataire(marchand.getEmail());	
				 mail.setObjet("Code de confirmation - EPaiement");
				 mail.setMessage(message);
				 //msgStatus = serviceMail.sendMail(mail);				
				
				  if (cmRepository.save(marchand) != null) {
					/*
					   if (msgStatus>0)
						  retourTrt = new MessageStatut("08", msgRepository.getLibelleMessage("08"));
					  }
					  */
					  
					  retourTrt = new MessageStatut("08", msgRepository.getLibelleMessage("08"));
					  
				  }
			  }
			
		} catch (Exception e) {
			retourTrt = new MessageStatut("99", msgRepository.getLibelleMessage("99"));
		}
		
		
		
		return retourTrt;
	}

	@Override
	public List<Transaction> getLisTransactions(String loginAdd) {
		
		return tranRepository.getListeTransaction(loginAdd);
	}
	
	@Override
	public List<CompteMarchandDTO> listePaiement(String loginAdd){	
		List<CompteMarchand> marchands = cmRepository.listePaiement(loginAdd);
		List<CompteMarchandDTO> marchandDTO = marchands.stream()
				.map(march -> mapperDTO.fromCompteMarchandToDTO(march))
				.collect(Collectors.toList());		
		
		return marchandDTO;
	}
    
}