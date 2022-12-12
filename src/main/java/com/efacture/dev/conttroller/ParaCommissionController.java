package com.efacture.dev.conttroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.efacture.dev.model.ParaCommission;

import com.efacture.dev.repository.ParaCommissionRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class ParaCommissionController {

	@Autowired
	private ParaCommissionRepository paraCommissionRepository  ;

	@GetMapping("/commissions")
	public List<ParaCommission> getAllCommission(){
		return paraCommissionRepository.findAll();
	}

}