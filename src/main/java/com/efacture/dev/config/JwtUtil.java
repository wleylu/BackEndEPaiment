package com.efacture.dev.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtUtil {

	private String secret;
	private int jwtExpirationInMs;
	
	
	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Value("${jwt.expirationDateInMs}")
	public void setJwtExpirationInMs(int jwtExpirationInMs) {	
		this.jwtExpirationInMs = jwtExpirationInMs;
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();

		
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		
		
		if (roles.contains(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"))) {
			claims.put("isSuperAdmin", true);
		}


		if (roles.contains(new SimpleGrantedAuthority("ROLE_PRESTATAIRE"))) {
			claims.put("isPrestataire", true);
		}
		
		if (roles.contains(new SimpleGrantedAuthority("ROLE_APPLICATION"))) {
			claims.put("isApplication", true);
		}
		
		if (roles.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			claims.put("isAdmin", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
			claims.put("isUser", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_AUDIT"))) {
			claims.put("isAudit", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER_PERSO"))) {
			claims.put("isUserPerso", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_USER_COM"))) {
			claims.put("isUserCom", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_HELPDESK"))) {
			claims.put("isHelpDesk", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_MONETIQUE"))) {
			claims.put("isMonetique", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_COMPTABILITE"))) {
			claims.put("isComptabilite", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_SUPPORT"))) {
			claims.put("isSupport", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("ROLE_SUPERVISEUR"))) {
			claims.put("isSuperviseur", true);
		}
				
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
	
		return  Jwts.builder().setClaims(claims).setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
		

	}

	@SuppressWarnings("unused")
	public boolean validateToken(String authToken) {
		try {
			
			Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
			
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		} catch (ExpiredJwtException ex) {
			
			throw ex;
		}
	}

	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();		
		claims.setExpiration(new Date(System.currentTimeMillis() +jwtExpirationInMs + 200000));			
		return claims.getSubject();

	}

	public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();		

		List<SimpleGrantedAuthority> roles = null;

		Boolean isSuperAdmin = claims.get("isSuperAdmin", Boolean.class);
		Boolean isAdmin = claims.get("isAdmin", Boolean.class);
		Boolean isUser = claims.get("isUser", Boolean.class);
		Boolean isAudit = claims.get("isAudit", Boolean.class);
		Boolean isUserPerso = claims.get("isUserPerso", Boolean.class);
		Boolean isUserCom = claims.get("isUserCom", Boolean.class);
		Boolean isHelpDesk = claims.get("isHelpDesk", Boolean.class);
		Boolean isMonetique = claims.get("isMonetique", Boolean.class);
		Boolean isComptabilite = claims.get("isComptabilite", Boolean.class);
		Boolean isSupport = claims.get("isSupport", Boolean.class);
		Boolean isSuperviseur = claims.get("isSuperviseur", Boolean.class);
		Boolean isPrestataire = claims.get("isPrestataire", Boolean.class);
		Boolean isApplication = claims.get("isApplication", Boolean.class);
		
		
		if (isSuperAdmin != null && isSuperAdmin) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"));
		}
		
		if (isPrestataire != null && isPrestataire) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_PRESTATAIRE"));
		}
		if (isApplication != null && isApplication) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_APPLICATION"));
		}
		if (isAdmin != null && isAdmin) {
		
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		if (isUser != null && isUser) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
		if (isAudit != null && isAudit) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_AUDIT"));
		}
		if (isUserPerso != null && isUserPerso) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER_PERSO"));
		}
		if (isUserCom != null && isUserCom) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER_COM"));
		}
		if (isHelpDesk != null && isHelpDesk) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_HELPDESK"));
		}
		if (isMonetique != null && isMonetique) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_MONETIQUE"));
		}
		if (isComptabilite != null && isComptabilite) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_COMPTABILITE"));
		}
		if (isSupport != null && isSupport) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_SUPPORT"));
		}
		if (isSuperviseur != null && isSuperviseur) {
			roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_SUPERVISEUR"));
		}
		
		//roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));

		return roles;

	}

}
