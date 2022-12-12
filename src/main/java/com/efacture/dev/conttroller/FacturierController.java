package com.efacture.dev.conttroller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.efacture.dev.model.Facturier;

import com.efacture.dev.repository.FacturieRepository;


@CrossOrigin("*")
@RestController
@RequestMapping("/efacture")
public class FacturierController {
	@Autowired
	private FacturieRepository facturieRepository;
	@PostMapping("/upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		
		Facturier img = new Facturier(file.getOriginalFilename(), file.getContentType(),
				compressZLib(file.getBytes()));
		facturieRepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}
	@GetMapping(path = { "/get/{imageName}" })
	public Facturier getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<Facturier> retrievedImage = facturieRepository.findByName(imageName);
		Facturier img = new Facturier(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressZLib(retrievedImage.get().getPicByte()));
		return img;
	}
	// compress the image bytes before storing it in the database
		public static byte[] compressZLib(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
		
			return outputStream.toByteArray();
		}
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressZLib(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	/*
	 * @PostMapping("/rechercheByIdent") public ResponseEntity<Facturier>
	 * rechercheByIdent(@RequestBody Facturier facturier){ Facturier fact =
	 * facturieImpl.getListFacture(facturier.getIdentifiant());
	 * //paie.setMontantFacture(paiement.getMontantFacture()); return
	 * ResponseEntity.ok(fact); }
	 */
	/*
	 * @GetMapping("/facturier/liste") public ResponseEntity<List<Facturier>>
	 * recupererFacture(){
	 * 
	 * return ResponseEntity.ok(facturieImpl.listeFactureEntity()); }
	 */
//	@SuppressWarnings("unchecked")
//	@PostMapping("/rechercheByIdent")
//	public List<Facturier> rechercheByIdent(@RequestBody Facturier facturier){
//		List<Facturier> fact = facturieImpl.listeFacture(facturier.getIdentifiant());
//		//paie.setMontantFacture(paiement.getMontantFacture());
//		return fact;
//	}
}