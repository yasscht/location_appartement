package com.appartementlocation.projet.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class FaciliteServiceImpl implements com.appartementlocation.projet.services.FaciliteService{
	
	private final com.appartementlocation.projet.repository.FaciliteRepository faciliteRepository;
	
	

	public FaciliteServiceImpl(com.appartementlocation.projet.repository.FaciliteRepository faciliteRepository) {
		super();
		this.faciliteRepository = faciliteRepository;
	}

	@Override
	public com.appartementlocation.projet.models.Facilite saveFacilite(com.appartementlocation.projet.models.Facilite Facilite) {
		// TODO Auto-generated method stub
		return faciliteRepository.save(Facilite);
	}

	@Override
	public List<com.appartementlocation.projet.models.Facilite> getFacilites() {
		// TODO Auto-generated method stub
		return faciliteRepository.findAll();
	}

	@Override
	public com.appartementlocation.projet.models.Facilite getFacilite(Long id) {
		// TODO Auto-generated method stub
		return faciliteRepository.getById(id);
	}

	@Override
	public void DeleteFacilite(Long id) {
		com.appartementlocation.projet.models.Facilite facilite = getFacilite(id);
		faciliteRepository.delete(facilite);
		
	}

}
