package com.efacture.dev.service;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CryptageDatas {

	private SecretKey secret ;
	
	
	
	

	public CryptageDatas() {
		String cle="abi_banque_22_ci";
		this.secret = new SecretKeySpec(cle.getBytes(),0,cle.length(),"AES");
	}


	public String cryptageData(String data) throws Exception {
		
			String encrypted = null;
		
			if (data.length()>1)
			{
				Cipher cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.ENCRYPT_MODE, this.secret);
				byte[] dataCrypt = cipher.doFinal(data.getBytes());
				encrypted = Base64.getEncoder().encodeToString(dataCrypt);
				return encrypted;
			}
			else
		   return encrypted;
	}
	
	
	public String decryptageData(String data) throws Exception{
		String encrypted = null;
		if(data.length()>10) {
			byte[] textConvert = Base64.getDecoder().decode(data.getBytes());
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, this.secret);
			byte[] dataCrypt = cipher.doFinal(textConvert);
			encrypted = new String(dataCrypt);
			return encrypted;
		}
		else
		return encrypted;
	}
	
	/*
	 * public static void main(String[] args) throws Exception { CryptageDatas
	 * crypto = new CryptageDatas();
	 * 
	 * String text ="KOne Yacouba 2022"; String retour = crypto.cryptageData(text);
	 * 
	 * System.out.println(retour);
	 * 
	 * String dec = crypto.decryptageData(retour);
	 * 
	 * System.out.println(dec);
	 * 
	 * 
	 * }
	 */
	
}
