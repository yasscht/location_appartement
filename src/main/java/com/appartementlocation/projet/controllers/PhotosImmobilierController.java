package com.appartementlocation.projet.controllers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appartementlocation.projet.models.PhotosImmobilier;
import com.appartementlocation.projet.services.impl.PhotosImmobilierServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping(path = "/api")
public class PhotosImmobilierController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	@Autowired
	private  PhotosImmobilierServiceImpl photosImmobilierServiceImpl;


	 @PostMapping("/uploadFile")
	    public PhotosImmobilier uploadFile(@RequestParam("file") MultipartFile file) {
	    	return photosImmobilierServiceImpl.storeFile(file);

	        /*String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadFile/")
	                .path(fileName.getFileName())
	                .toUriString();

	        return new Response(fileName.getFileName(), fileDownloadUri,
	                file.getContentType(), file.getSize());*/
	    	
	    }

	    @PostMapping("/uploadFiles")
	    public List<PhotosImmobilier> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
	        return Arrays.asList(files)
	                .stream()
	                .map(file -> uploadFile(file))
	                .collect(Collectors.toList());
	    }
	    @GetMapping("/photo/all")
	    public List<PhotosImmobilier> getPhotosImmobiliers() {
			// TODO Auto-generated method stub
			return photosImmobilierServiceImpl.getPhotosImmobiliers();
		}
	
	
	
}
