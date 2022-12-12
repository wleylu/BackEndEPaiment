package com.efacture.dev.repository;

 

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.efacture.dev.model.SignalitiqueTest;
 

public interface SignalitiqueRepository extends JpaRepository<SignalitiqueTest, String> {
    public SignalitiqueTest findByClient(String client);
    public SignalitiqueTest findByEmail(String email);
    public List<SignalitiqueTest> findByNomContaining(String nom);
    public List<SignalitiqueTest> findByLoginContaining(String login);
    public List<SignalitiqueTest> findByLogin(String login);
    public List<SignalitiqueTest> findByNomContainingAndLoginContaining(String nom,String login);
    List<SignalitiqueTest> findAllByDateCreationBetween(Date dateDebut,Date dateFin);
    //public CompteMarchand findByCode(Long code);
    /*
     * @Query("Select c from CompteMarchand c where c.nom like :x") public
     * List<CompteMarchand> rechercheByCm(@Param("x") String cm);
     */
}