package com.appartementlocation.projet.services.impl;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.models.Annonce;
import com.appartementlocation.projet.models.Equipement;
import com.appartementlocation.projet.models.Facilite;
import com.appartementlocation.projet.models.PhotosImmobilier;
import com.appartementlocation.projet.models.Reglement;
import com.appartementlocation.projet.models.User;
import com.appartementlocation.projet.repository.AnnonceRepository;
import com.appartementlocation.projet.repository.EquipementRepository;
import com.appartementlocation.projet.repository.FaciliteRepository;
import com.appartementlocation.projet.repository.PhotosImmobilierRepository;
import com.appartementlocation.projet.repository.ReglementReposotory;
import com.appartementlocation.projet.repository.UserRepository;
import com.appartementlocation.projet.services.AnnonceService;
import com.appartementlocation.projet.utils.JwtUtil;




@Service

@Transactional 

public class AnnonceServiceImpl implements AnnonceService{
	@Autowired
	private JwtUtil jwtUtil;
	private final AnnonceRepository annonceRepository;
	private final UserRepository userRepository;
	private final EquipementRepository equipementRepository;
	private final ReglementReposotory reglementReposotory;
	private final FaciliteRepository faciliteRepository;
	private final PhotosImmobilierRepository photosImmobilierRepository;

	

	public AnnonceServiceImpl(AnnonceRepository annonceRepository, EquipementRepository equipementRepository,
			ReglementReposotory reglementReposotory, FaciliteRepository faciliteRepository,
			PhotosImmobilierRepository photosImmobilierRepository,UserRepository userRepository) {
		super();
		this.annonceRepository = annonceRepository;
		this.equipementRepository = equipementRepository;
		this.reglementReposotory = reglementReposotory;
		this.faciliteRepository = faciliteRepository;
		this.photosImmobilierRepository = photosImmobilierRepository;
		this.userRepository=userRepository;
	}

	@Override
	public Annonce saveAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		User user=new User();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String username="";
			if (principal instanceof UserDetails) {
			 username = ((UserDetails)principal).getUsername();
			} else {
			username = principal.toString();
			}
			user.setUserName(username);
		annonce.setUser(user);	
		return annonceRepository.save(annonce);
	}

	@Override
	public Annonce getAnnonce(Long id) {
		// TODO Auto-generated method stub
		return annonceRepository.getById(id);
	}

	@Override
	public List<Annonce> getAnnonces() {
		// TODO Auto-generated method stub
		return annonceRepository.findAll();
	}

	@Override
	public void DeleteAnnonce(Long id) {
		Annonce annonce = getAnnonce(id);
		annonceRepository.delete(annonce);
		
	}

	@Override
	public void addEquipementToAnnonce(Long idAnnonce, Long idEquipement) {
		Annonce annonce = getAnnonce(idAnnonce);
		Equipement Equipement = equipementRepository.getById(idEquipement);
		annonce.getEquipement().add(Equipement);
		
	}

	@Override
	public void addReglementToAnnonce(Long idAnnonce, Long idReglement) {
		Annonce annonce = getAnnonce(idAnnonce);
		Reglement Reglement = reglementReposotory.getById(idReglement);
		annonce.getReglement().add(Reglement);
	}

	@Override
	public void addFaciliteToAnnonce(Long idAnnonce, Long idFacilite) {
		Annonce annonce = getAnnonce(idAnnonce);
		Facilite facilite = faciliteRepository.getById(idFacilite);
		annonce.getFacilite().add(facilite);
	}

	@Override
	public void addPhotoToAnnonce(Long idAnnonce, PhotosImmobilier photosImmobilier) {
		Annonce annonce = getAnnonce(idAnnonce);
		
		annonce.getPhotosImmobilier().add(photosImmobilier);
		
	}

	@Override

	public List<Annonce> getMesAnnonces() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String username="";
		if (principal instanceof UserDetails) {
		 username = ((UserDetails)principal).getUsername();
		} else {
		username = principal.toString();
		}
		// TODO Auto-generated method stub
		return annonceRepository.findByUser(username);
	}

	@Override
	public Annonce updateAnnon(Annonce annonce) {
		Annonce annonce_up=annonceRepository.findById(annonce.getId()).orElse(null);
		annonce_up.setTitle(annonce.getTitle());
		annonce_up.setPublicCible(annonce.getPublicCible());
		annonce_up.setDateDisponibilite(annonce.getDateDisponibilite());
		annonce_up.setPrixMois(annonce.getPrixMois());
	    annonce_up.setNombrePersonnes(annonce.getNombrePersonnes());
	    annonce_up.setNombrePersonnes(annonce.getNombrePersonnes());
	    annonce_up.setEtage(annonce.getEtage());
	    annonce_up.setAdresse(annonce.getAdresse());
	    annonce_up.setEquipement(annonce.getEquipement());
	    annonce_up.setFacilite(annonce.getFacilite());
	    annonce_up.setReglement(annonce.getReglement());
	   return annonceRepository.save(annonce_up);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Annonce> getAnnoncesByGender(PublicCible gender) {
		// TODO Auto-generated method stub
		return annonceRepository.findByPublicCible(gender);
	}

	@Override
	public List<Annonce> getAnnoncesByPrice(float prix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annonce> getAnnoncesByNbrPersonne(int nbr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annonce> filterAnnonceByPrice(int min, int max) {
		// TODO Auto-generated method stub
		return annonceRepository.findByPrixMoisBetween(min, max);
	}

	@Override
	public List<Annonce> filterByDateDisponibiliter(Date date_debut, Date debut_fin) {
		// TODO Auto-generated method stub
		return annonceRepository.findByDateDisponibilite(date_debut, date_debut);
	}

	

	
	

}
