package com.efacture.dev.repository;

 

import java.util.Date;
import java.util.List;

 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.efacture.dev.model.Compte;
import com.efacture.dev.model.CompteMarchand;


public interface CmRepository extends JpaRepository<CompteMarchand, String> {
	public CompteMarchand findById(Long id);
    public CompteMarchand findByClient(String client);    
    @Query(value = "select * from compte_marchand m where ref_transaction=:refTransaction and etatoper='NP' and valide!='S' "
    		+ "and not exists(select 1 from transaction where ref_transaction = m.ref_transaction)",nativeQuery = true)
    public CompteMarchand findByRefTransac(@Param("refTransaction") String refTransaction);
    
    @Query(value = "select * from compte_marchand where ref_transaction=:refTransaction and code_transaction=:codeTransaction "
    		+ "and code_confirmation=:codeConfirmation and etatoper='NP'",nativeQuery = true)
    public CompteMarchand getVerifiePaiement(@Param("refTransaction") String refTransaction,
    		@Param("codeTransaction") String codeTransaction,
    		@Param("codeConfirmation") String codeConfirmation);
    
    
    @Query(value = "select count(ref_transaction) from compte_marchand where ref_transaction= :refTransaction "
    		+ "and code_transaction= :codeTransaction and code_confirmation= :codeConfirmation and etatoper='NP'",nativeQuery = true)
    public int getValideCode(@Param("refTransaction") String refTransaction,
    		@Param("codeTransaction") String codeTransaction,
    		@Param("codeConfirmation") String codeConfirmation);
   
    @Query(value = "select *  from compte_marchand where ref_transaction= :refTransaction "
    		+ "and code_transaction= :codeTransaction and code_confirmation= :codeConfirmation and etatoper='NP'",nativeQuery = true)
    public CompteMarchand getMarchandPay(@Param("refTransaction") String refTransaction,
    		@Param("codeTransaction") String codeTransaction,
    		@Param("codeConfirmation") String codeConfirmation);
    
    public CompteMarchand findByCodeTransaction(String codeTransaction);
    public CompteMarchand findByEmail(String email);
    public List<CompteMarchand> findByNomContaining(String nom);
    public List<CompteMarchand> findByLoginContaining(String login);
    public List<CompteMarchand> findByLogin(String login);
    public List<CompteMarchand> findByNomContainingIgnoreCaseAndRefTransactionContainingIgnoreCase(String nom,String login);
    
    @Query(value = "SELECT * FROM compte_marchand WHERE ref_transaction like %?1% AND nom like %?2% and login_add=?3 ", nativeQuery = true)
    public List<CompteMarchand> listeComptesMarchands(String refTransaction,String nom,String login);
    
    @Query(value = "SELECT * FROM compte_marchand where login_modification = :login and etatoper='PA'", nativeQuery = true)
    public List<CompteMarchand> listePaiement(@Param("login") String login);
    
    @Query(value = "SELECT * FROM compte_marchand where login_modification = :login "
    		+ "and ref_transaction like %:refTran% and code_transaction like %:codeTran% "
    		+ " and date_modification BETWEEN to_date(:dateDebut,'YYYY-MM-DD') and to_date(:dateFin,'YYYY-MM-DD') and etatoper='PA'", nativeQuery = true)
    public List<CompteMarchand> listeTransacDate(@Param("login") String login,
    				@Param("refTran") String refTran,
    				@Param("codeTran") String codeTran,
    				@Param("dateDebut") String dateDebut,
    				@Param("dateFin") String dateFin
    				);
    
    @Query(value = "SELECT * FROM compte_marchand where login_modification = :login "
    		+ "and ref_transaction like %:refTran% and code_transaction like %:codeTran% and etatoper='PA'", nativeQuery = true)
    public List<CompteMarchand> listeTransaction(@Param("login") String login,
    				@Param("refTran") String refTran,
    				@Param("codeTran") String codeTran);
    
    List<CompteMarchand> findAllByDateCreationBetween(Date dateDebut,Date dateFin);
    //public CompteMarchand findByCode(Long code);
    /*
     * @Query("Select c from CompteMarchand c where c.nom like :x") public
     * List<CompteMarchand> rechercheByCm(@Param("x") String cm);
     */
    @Query(value = "SELECT email FROM compte_marchand WHERE email=?1", nativeQuery = true)
	public String getByMarchandByMail(String email);
	public CompteMarchand findByTel(String tel);
}