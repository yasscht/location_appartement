package com.appartementlocation.projet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.models.Equipement;


@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Long>{

}
