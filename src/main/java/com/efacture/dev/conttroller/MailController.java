package com.efacture.dev.conttroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.Mail;
import com.efacture.dev.serviceImpl.SendMailService;

//import com.caisse.projet.Model.Mail;
//import com.caisse.projet.Service.SendMailService;

import java.util.List;

import javax.mail.MessagingException;
@CrossOrigin("*")
@RestController
@RequestMapping("efacture")
public class MailController {
	@Autowired
	private SendMailService service;
	
	 @PostMapping("/mails/email")
	    public long save(@RequestBody Mail mail) {		 
	        return service.sendMail(mail);
	    }
  

    @PostMapping("/mails/attachment")
    
    public ResponseEntity<String> sendAttachmentEmail(@RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
    
    @GetMapping("/mails/email")
    public List<Mail> list() {
	// System.out.println("Get all Categories...");
             return service.getAll();
   }
}
