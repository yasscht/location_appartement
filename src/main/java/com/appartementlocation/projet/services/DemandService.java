package com.appartementlocation.projet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Demand;
@Service
public interface DemandService {
	
	Demand saveDemand(Demand demand);
	List<Demand> getAllDemandForAnAnnonce(long id);
	Demand UpdateDemand(Demand demand,Long id);
	void DeleteDemand(Long id);
	void AcceptDemand(Long id);
	void RefusDemand(Long id);

}
