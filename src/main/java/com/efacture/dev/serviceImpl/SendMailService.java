package com.efacture.dev.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.efacture.dev.model.ConfigApp;
import com.efacture.dev.model.Mail;
import com.efacture.dev.repository.MailRepository;

//import com.caisse.projet.Model.Mail;

//import com.caisse.projet.Repository.MailRepository;

import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
@Service
@Transactional
public class SendMailService {
	 @Autowired
	private  JavaMailSender javaMailSender;
	@Autowired
	MailRepository repository;
	
	private ConfigApp confApp;
	
	
	public SendMailService(){
		try {
			this.confApp = new ConfigApp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public long sendMail(Mail mail) throws MailException{
    	//System.out.println("Envoi du mail en cours..");
    	 SimpleMailMessage msg = new SimpleMailMessage();
  
         msg.setTo(mail.getDestinataire());
         msg.setFrom(this.confApp.getEmail());
         msg.setSubject(mail.getObjet());
         msg.setText(mail.getMessage());
         msg.setCc(this.confApp.getEmailcc());
         javaMailSender.send(msg);
        return repository.save(mail)
                             .getId();
    }
    public void sendMailWithAttachments(Mail mail) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        
        helper.setTo(mail.getDestinataire());
        helper.setSubject(mail.getObjet());
        helper.setText(mail.getMessage(), true);
        helper.addAttachment("logo.jpg", new ClassPathResource("logo.jpg"));
        javaMailSender.send(msg);
    }

	public List<Mail> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
