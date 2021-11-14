package com.appartementlocation.projet.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.enumeration.StatusDemand;
import com.appartementlocation.projet.models.Demand;
import com.appartementlocation.projet.repository.DemandRepository;
import com.appartementlocation.projet.services.DemandService;
@Service
public class DemandServiceImpl implements DemandService{
	
	private final DemandRepository remandRepository;
	

	public DemandServiceImpl(DemandRepository remandRepository) {
		super();
		this.remandRepository = remandRepository;
	}

	@Override
	public Demand saveDemand(Demand demand) {
		return remandRepository.save(demand);
	}

	@Override
	public List<Demand> getAllDemandForAnAnnonce(long id) {
		
		return remandRepository.findByAnnonce(id);
	}

	@Override
	public Demand UpdateDemand(Demand demand, Long id) {
		Demand demandInDatabase = remandRepository.getById(id);
		demandInDatabase.setDateDebutLocation(demand.getDateDebutLocation());
		demandInDatabase.setDateFinLocation(demand.getDateFinLocation());
		demandInDatabase.setGenre(demand.getGenre());
		demandInDatabase.setNombrePersonnes(demand.getNombrePersonnes());
		demandInDatabase.setUpdated_at(LocalDateTime.now());
		return remandRepository.save(demandInDatabase);
		
	}

	@Override
	public void DeleteDemand(Long id) {
		Demand demandInDatabase = remandRepository.getById(id);
		remandRepository.delete(demandInDatabase);
	}

	@Override
	public void AcceptDemand(Long id) {
		Demand demandInDatabase = remandRepository.getById(id);
		demandInDatabase.setStatus(StatusDemand.ACCEPTED);
		remandRepository.save(demandInDatabase);
	}

	@Override
	public void RefusDemand(Long id) {
		Demand demandInDatabase = remandRepository.getById(id);
		demandInDatabase.setStatus(StatusDemand.REFUSED);
		remandRepository.save(demandInDatabase);
		
	}

}
