package com.appartementlocation.projet.services;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.models.Annonce;
import com.appartementlocation.projet.models.PhotosImmobilier;
import com.appartementlocation.projet.models.User;

@Service
public interface AnnonceService {
	Annonce saveAnnonce(Annonce annonce);
	
	Annonce getAnnonce(Long id);
	List<Annonce> getAnnonces();
	void DeleteAnnonce(Long id);
	void addEquipementToAnnonce(Long idAnnonce,Long idEquipement);
	void addReglementToAnnonce(Long idAnnonce,Long idReglement);
	void addFaciliteToAnnonce(Long idAnnonce,Long idFacilite);

	void addPhotoToAnnonce(Long idAnnonce,PhotosImmobilier photosImmobilier);
    Annonce updateAnnon(Annonce annonce);
	

	List<Annonce> getMesAnnonces();
	List<Annonce> getAnnoncesByGender(PublicCible gender);
	List<Annonce> getAnnoncesByPrice(float prix);
	List<Annonce> getAnnoncesByNbrPersonne(int nbr);

	
	List<Annonce> filterAnnonceByPrice(int min,int max);
	List<Annonce> filterByDateDisponibiliter(Date date_debut,Date debut_fin);
} 
