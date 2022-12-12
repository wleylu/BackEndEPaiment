package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.CompteMarchand;
import com.efacture.dev.serviceImpl.CmImpl;
@CrossOrigin("*")
@RestController
public class ResourceController {
	@Autowired
	private CmImpl cmImpl;
	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@RequestMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}
	@GetMapping("/marchands")
    public ResponseEntity<List<CompteMarchand>> recupererCptMarchand1(){
        
        return ResponseEntity.ok(cmImpl.listMarchands());
    }
}
