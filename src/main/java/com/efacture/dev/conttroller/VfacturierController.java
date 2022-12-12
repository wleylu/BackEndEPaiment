package com.efacture.dev.conttroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.efacture.dev.model.Vfacturier;
import com.efacture.dev.repository.VfacturierRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/efacture/")
public class VfacturierController {

	@Autowired
	private VfacturierRepository vfacturierRepository;

	@GetMapping("/facturier/Allfacturier")
	public List<Vfacturier> getAllFacturier() {
		return vfacturierRepository.findAll();
	}

	@PostMapping("/facturier/Addfacturier")
	public Vfacturier creerFacturier(@RequestBody Vfacturier facturier) {
		return vfacturierRepository.save(facturier);
	}
}