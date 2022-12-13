package com.efacture.dev.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
//        corsConfiguration.setAllowedOrigins(List.of("*"));
//        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH", "DELETE"));
//        corsConfiguration.setAllowCredentials(false);
//        corsConfiguration.setExposedHeaders(List.of("Authorization"));

		// You can customize the following part based on your project, it's only a
		// sample

		http.csrf().disable().cors().and().authorizeRequests()
				.antMatchers("hellouser", "/helloadmin", "/efacture/facturier/**","Api/paie/presta/cie/","/Api/paie/sodeci/",
						"/Api/pay","/efacture/consultation/**")
				.hasAnyRole("SUPER_ADMIN", "ADMIN", "USER_PERSO", "USER_COM", "AUDIT", "COMPTABILITE", "HELPDESK",
						"MONETIQUE", "COMPTABILITE", "SUPPORT", "SUPERVISEUR", "PRESTATAIRE","APPLICATION", "USER")
				.antMatchers("/efacture/consultation/**")
				.hasAnyRole("SUPER_ADMIN", "ADMIN", "USER_PERSO", "USER_COM", "AUDIT", "COMPTABILITE", "HELPDESK",
						"MONETIQUE", "COMPTABILITE", "SUPPORT", "SUPERVISEUR", "PRESTATAIRE", "USER")
				.antMatchers("hellouser", "/efacture/audit/*").hasAnyRole("SUPER_ADMIN", "ADMIN", "AUDIT")
				.antMatchers("hellouser", "/efacture/cm/**", "/efacture/plafond/**", "/efacture/user/**")
				.hasAnyRole("SUPER_ADMIN", "USER_COM", "USER_PERSO", "ADMIN", "HELPDESK", "COMPTABILITE", "SUPPORT",
						"SUPERVISEUR", "USER")
				.antMatchers("hellouser", "/efacture/commission/**")
				.hasAnyRole("SUPER_ADMIN", "USER_COM", "USER_PERSO", "ADMIN", "HELPDESK", "COMPTABILITE", "SUPERVISEUR",
						"USER")
				.antMatchers("/efacture/type/**", "/efacture/paie/**", "/efacture/em/**", "/efacture/rg/**", "/Api/pay",
						"/Api/facture/**")
				.hasAnyRole("SUPER_ADMIN", "USER_COM", "USER_PERSO", "ADMIN", "HELPDESK", "COMPTABILITE", "SUPERVISEUR",
						"USER","APPLICATION")
				.antMatchers("/efacture/facturefavoris/*")
				.hasAnyRole("SUPER_ADMIN", "ADMIN", "USER_COM", "USER_PERSO", "PRESTATAIRE")
				.antMatchers("/template/signalitique/**")
				.hasAnyRole("SUPER_ADMIN", "ADMIN", "HELPDESK", "SUPERVISEUR", "USER")
//				.antMatchers("/efacture/reclamation/**").hasAnyRole("SUPER_ADMIN", "ADMIN", "USER_COM", "USER_PERSO")
				.antMatchers("/efacture/comptes/**")
				.hasAnyRole("SUPER_ADMIN", "ADMIN", "HELPDESK", "SUPERVISEUR", "USER", "USER_COM", "USER_PERSO")				
				.antMatchers("/authenticate","/authenticated", "/register", "/efacture/detailUser/*", "/efacture/connexion",
						"/efacture/firstLogin","/efacture/rechercheUserEmail/*", "/efacture/tentativeConnect/*", "/efacture/bloqueUser/*","/efacture/erreurs/**","/Api/envoisms/**",
						"/efacture/deconnexion/*","/efacture/reclamation/**", "/efacture/mails/*", "/efacture/login", "/efacture/pwdParam/*","/efacture/chiffreStringg/*","/efacture/generermdp","/efacture/decrypter","/efacture/facturefavoris/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	}

}
