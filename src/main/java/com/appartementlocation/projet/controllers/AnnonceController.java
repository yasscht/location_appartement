package com.appartementlocation.projet.controllers;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.models.Annonce;
import com.appartementlocation.projet.models.User;
import com.appartementlocation.projet.payload.Date;
import com.appartementlocation.projet.payload.MinMax;
import com.appartementlocation.projet.repository.AnnonceRepository;
import com.appartementlocation.projet.services.PhotosImmobilierService;
import com.appartementlocation.projet.services.impl.AnnonceServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api")
public class AnnonceController {
	
	private final AnnonceServiceImpl annonceServiceImpl;
	private final PhotosImmobilierService photosImmobilierService;
	public final AnnonceRepository annonceRepository;
	
	
	

	public AnnonceController(AnnonceServiceImpl annonceServiceImpl, PhotosImmobilierService photosImmobilierService,
			AnnonceRepository nnonceRepository) {
		super();
		this.annonceServiceImpl = annonceServiceImpl;
		this.photosImmobilierService = photosImmobilierService;
		this.annonceRepository = nnonceRepository;
	}

	@PostMapping("/annonce/save")
	public Annonce saveAnnonce(@RequestBody Annonce annonce) {
	          return annonceServiceImpl.saveAnnonce(annonce);
	}
	
	@GetMapping("/annonces")
	public ResponseEntity<List<Annonce>> getAnnonces(){
		return ResponseEntity.ok().body(annonceServiceImpl.getAnnonces());
	}
	@PostMapping("/annonce/update")
	public Annonce updateAnnonce(@RequestBody Annonce annonce) {
		return annonceServiceImpl.updateAnnon(annonce);
	}
	@GetMapping("annonce/{id}")
	@ResponseBody
	public ResponseEntity<Annonce> getAnnonce(@PathVariable Long id){
		return ResponseEntity.ok().body(annonceServiceImpl.getAnnonce(id));
	} 
	
	@GetMapping("annonce/mes_annonces")
	public List<Annonce> getMesAnnonces(){
		return annonceServiceImpl.getMesAnnonces();
	}
	
	
	@DeleteMapping("annonce/delete/{id}")
	public String DeleteAnnonce(@PathVariable Long id) {
		annonceServiceImpl.DeleteAnnonce(id);
		return "Annonce deleted succesfuly!";
	}
	
	
	
	
	@PostMapping("annonce/addequipement")
	public ResponseEntity<?>  addEquipementToAnnonce(@RequestBody EquipementToAnnonceForm  equipementToAnnonceForm) {
		annonceServiceImpl.addEquipementToAnnonce(equipementToAnnonceForm.getIdAnnonce(), equipementToAnnonceForm.getIdEquipement());
		return ResponseEntity.ok().build();
	}
	
	
	
	@PostMapping("annonce/addreglement")
	public ResponseEntity<?>  addReglementToAnnonce(@RequestBody ReglementToAnnonceForm  reglementToAnnonceForm) {
		annonceServiceImpl.addReglementToAnnonce(reglementToAnnonceForm.getIdAnnonce(), reglementToAnnonceForm.getIdReglement());
		return ResponseEntity.ok().build();
	}
	

	@PostMapping("annonce/addfacilite")
	public ResponseEntity<?>  addFaciliteToAnnonce(@RequestBody FaciliteTpAnnonceForm faciliteTpAnnonceForm  ) {
		annonceServiceImpl.addFaciliteToAnnonce(faciliteTpAnnonceForm.getIdAnnonce(), faciliteTpAnnonceForm.getIdFacilite());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/annonces/{gender}")
	@ResponseBody
	public ResponseEntity<List<Annonce>> getfilterByGender(@PathVariable String gender){
		
		
		if(gender.equals("HOMME")) {
			return ResponseEntity.ok().body(annonceServiceImpl.getAnnoncesByGender(PublicCible.HOMME));
			
		}else if(gender.equals("FEMME")) {
		return ResponseEntity.ok().body(annonceServiceImpl.getAnnoncesByGender(PublicCible.FEMME));
		}else {
			return null;
		}
	} 
	@PostMapping("/annonces/price")

	public List<Annonce> getfilterByGender(@RequestBody MinMax obj){
		
		
		
			return annonceServiceImpl.filterAnnonceByPrice(obj.getMin(), obj.getMax());
			
	
	}
	@PostMapping("/annonces/date")

	public List<Annonce> getfilterByDate(@RequestBody Date obj){
		

			return annonceServiceImpl.filterByDateDisponibiliter(obj.getDate_fin(), obj.getDate_debut());
			
	
	}

}



class EquipementToAnnonceForm {
	private Long idAnnonce;
	private Long idEquipement;
	
	public EquipementToAnnonceForm(Long idAnnonce, Long idEquipement) {
		super();
		this.idAnnonce = idAnnonce;
		this.idEquipement = idEquipement;
	}
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public Long getIdEquipement() {
		return idEquipement;
	}
	public void setIdEquipement(Long idEquipement) {
		this.idEquipement = idEquipement;
	}
	
	
	
}




class ReglementToAnnonceForm {
	private Long idAnnonce;
	private Long idReglement;
	public ReglementToAnnonceForm(Long idAnnonce, Long idReglement) {
		super();
		this.idAnnonce = idAnnonce;
		this.idReglement = idReglement;
	}
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public Long getIdReglement() {
		return idReglement;
	}
	public void setIdReglement(Long idReglement) {
		this.idReglement = idReglement;
	}
	
	
}




class FaciliteTpAnnonceForm {
	private Long idAnnonce;
	private Long idFacilite;
	
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	
	public Long getIdFacilite() {
		return idFacilite;
	}
	
	public void setIdFacilite(Long idFacilite) {
		this.idFacilite = idFacilite;
	}
	
	public FaciliteTpAnnonceForm(Long idAnnonce, Long idFacilite) {
		super();
		this.idAnnonce = idAnnonce;
		this.idFacilite = idFacilite;
	}
}



class PhotoToAnnonceForm {
	private Long idAnnonce;
	private String url;
	public PhotoToAnnonceForm(Long idAnnonce, String url) {
		super();
		this.idAnnonce = idAnnonce;
		this.url = url;
	}
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}



