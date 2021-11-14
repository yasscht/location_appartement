package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.models.PhotosImmobilier;

@Repository
public interface PhotosImmobilierRepository extends JpaRepository<PhotosImmobilier,Long>{

}
