package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efacture.dev.model.passwordParametre;
import com.efacture.dev.repository.pwdParamRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class pwdParaController {

	@Autowired
	private pwdParamRepository pwdRepository;

	@GetMapping("/pwdParam/allParam")
	public List<passwordParametre> getAllParam() {
		return pwdRepository.findAll();
	}

	@PostMapping("/pwdParam/addParam")
	public passwordParametre addparams(@RequestBody passwordParametre parametre) {
		return pwdRepository.save(parametre);
	}

}
