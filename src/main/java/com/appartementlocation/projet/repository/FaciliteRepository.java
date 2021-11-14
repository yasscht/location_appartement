package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.models.Facilite;


@Repository
public interface FaciliteRepository extends JpaRepository<Facilite,Long> {

}
