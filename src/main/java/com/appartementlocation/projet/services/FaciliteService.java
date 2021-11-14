package com.appartementlocation.projet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Facilite;

@Service
public interface FaciliteService {
	
	Facilite saveFacilite(Facilite Facilite);
	List<Facilite> getFacilites();
	Facilite getFacilite(Long id);
	void DeleteFacilite(Long id);

}
