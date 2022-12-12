package com.efacture.dev.config;

import java.util.Arrays;
import java.util.List;

//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.efacture.dev.model.Mail;
import com.efacture.dev.model.Utilisateur;
import com.efacture.dev.model.UtilisateurDTO;
//import com.javainuse.springbootsecurity.model.DAOUser;
//import com.javainuse.springbootsecurity.model.UserDTO;
//import com.javainuse.springbootsecurity.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private com.efacture.dev.repository.UserRepository userDao;

	
	  @Autowired 
	  private PasswordEncoder bcryptEncoder;
	 
	
		
		 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;		
			Utilisateur user = userDao.findByLogin(username);
		if (user != null) {			
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getHabilitation()));
			return new User(user.getLogin(), user.getPassword1(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);	}
	
	public Utilisateur save(UtilisateurDTO user) {
		Utilisateur newUser = new Utilisateur();
		newUser.setLogin(user.getLogin());
		newUser.setNom(user.getNom());
		newUser.setPrenom(user.getPrenom());
		newUser.setPassword1(bcryptEncoder.encode(user.getPassword1()));
		newUser.setEmail(user.getEmail());
		newUser.setTel(user.getTel());
		newUser.setEmail(user.getEmail());
		newUser.setHabilitation(user.getHabilitation());
		newUser.setTypePlafond(user.getTypePlafond());
		newUser.setTypeComfirmation(user.getTypeComfirmation());
		newUser.setMdpOublie(user.getMdpOublie());
		newUser.setReinitialiser(false);
		newUser.setCptNbTransaction(user.getCptNbTransaction());
		newUser.setCptMontant(user.getCptMontant());
		Utilisateur users = userDao.save(newUser);

		return users;
		
	}
	/*
	 * private String generatePassword() { return
	 * "code"+RandomStringUtils.randomNumeric(10)+"spas"; }
	 */
	
}
