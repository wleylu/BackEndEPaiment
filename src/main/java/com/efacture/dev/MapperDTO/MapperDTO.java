package com.efacture.dev.MapperDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.efacture.dev.DTO.CompteMarchandDTO;
import com.efacture.dev.model.CompteMarchand;

@Service
public class MapperDTO {
	
	public CompteMarchandDTO fromCompteMarchandToDTO(CompteMarchand compteMarchand) {
		CompteMarchandDTO march = new CompteMarchandDTO();
		BeanUtils.copyProperties(compteMarchand,march);		
		return march;
	}
	
	public CompteMarchand fromCompteMarchandToDTO(CompteMarchandDTO compteMarchandDTO) {
		CompteMarchand march = new CompteMarchand();
		BeanUtils.copyProperties(compteMarchandDTO,march);		
		return march;
	}

}
