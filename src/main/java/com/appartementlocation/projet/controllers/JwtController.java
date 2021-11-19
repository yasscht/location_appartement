package com.appartementlocation.projet.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appartementlocation.projet.models.JwtRequest;
import com.appartementlocation.projet.models.JwtResponse;
import com.appartementlocation.projet.services.JwtService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin
public class JwtController {
   @Autowired
    private JwtService jwtService;
    
    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	return jwtService.createJwtToken(jwtRequest);
    }
  @GetMapping({"/deconnecter"})
  public String generateToken() { 
	  Map<String,Object>  claims=new HashMap<>();
	

		return Jwts.builder()
				.setClaims(claims)
				
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date())
				
				.compact();
	}
}
