package com.appartementlocation.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appartementlocation.projet.models.JwtRequest;
import com.appartementlocation.projet.models.JwtResponse;
import com.appartementlocation.projet.services.JwtService;

@RestController
@CrossOrigin
public class JwtController {
   @Autowired
    private JwtService jwtService;
    
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	return jwtService.createJwtToken(jwtRequest);
    }
}
