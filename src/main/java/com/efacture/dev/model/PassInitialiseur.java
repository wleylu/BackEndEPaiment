package com.efacture.dev.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.efacture.dev.service.CryptageDatas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassInitialiseur {
	private String pass1;
	private String pass2;
	private String pass3;
	private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,100}$";
	private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	 
	 
	 
	  public static boolean isValid(String password) {
	        Matcher matcher = pattern.matcher(password);
	        return matcher.matches();
	    }	 
	
	public boolean validedPass(){
		CryptageDatas crypData = new CryptageDatas();
		
		boolean reponse= true;
		boolean passfort= false;
		boolean statuPass= false;		
		
		String pass1= this.pass1;
		String pass2= null;
		String pass3= null;
		
		try {
			 pass2= crypData.decryptageData(this.pass2);
			 pass3 = crypData.decryptageData(this.pass3);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
		
		if ((pass2 != null || pass2 != "") && (pass1.equals(pass2))){	
		
				reponse = false;						
		}
		else if ((pass3 != null || pass3 != "") && (pass1.equals(pass3))) {		
				reponse = false;
				
		}
		else
		{
			    reponse =true;			
		}
		
		passfort = isValid(pass1);
		
		if (reponse && passfort) statuPass = true; else statuPass=false;
		
	
		return statuPass;
		
	}

}
