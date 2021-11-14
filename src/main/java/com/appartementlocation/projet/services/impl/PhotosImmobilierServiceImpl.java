package com.appartementlocation.projet.services.impl;
import org.springframework.web.multipart.MultipartFile;

import com.appartementlocation.projet.exception.FileNotFoundException;
import com.appartementlocation.projet.exception.FileStorageException;
import com.appartementlocation.projet.models.PhotosImmobilier;
import com.appartementlocation.projet.repository.AnnonceRepository;
import com.appartementlocation.projet.repository.PhotosImmobilierRepository;
import com.appartementlocation.projet.services.PhotosImmobilierService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class PhotosImmobilierServiceImpl implements PhotosImmobilierService{
   @Autowired
	private PhotosImmobilierRepository photosImmobilierRepository;
   @Autowired
	private AnnonceRepository annonceRepository;

	


public List<PhotosImmobilier> getAllPhotos(){
	return photosImmobilierRepository.findAll();
}
	



	public PhotosImmobilier storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            PhotosImmobilier dbFile = new PhotosImmobilier(fileName, file.getContentType(), file.getBytes());

            return photosImmobilierRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public PhotosImmobilier getFile(Long fileId) {
        return photosImmobilierRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
    }
	

	
    
	public List<PhotosImmobilier> getPhotosImmobiliers() {
		// TODO Auto-generated method stub
		return photosImmobilierRepository.findAll();
	}
	
}
