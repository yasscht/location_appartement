package com.appartementlocation.projet.controllers;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appartementlocation.projet.models.JwtRequest;
import com.appartementlocation.projet.models.JwtResponse;
import com.appartementlocation.projet.models.User;
import com.appartementlocation.projet.repository.UserRepository;
import com.appartementlocation.projet.services.JwtService;
import com.appartementlocation.projet.services.UserService;
import com.appartementlocation.projet.utils.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserService userService;
	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}
	@PostMapping({"/registerUser"})
public User registerUser(@RequestBody User user) {
	return userService.registerUser(user);
	
	
}
	@PostMapping({"/hello"})
	
	public UserDetails  getTestsListByUserId(@RequestBody String token){
         
	    
	    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
	    
	   
	    return userDetails;
	}
	@GetMapping({"/profil"})
	public User getDetails(HttpServletRequest request) {
	    
	  String token=request.getHeader("Authorization");
		String jwtToken=token.substring(7);
		String username=jwtUtil.getUserNameFromToken(jwtToken);
		User user= userRepository.findById(username).get();
		return user;
	  
	  
	    
	   
	    
	}
	
	
	@GetMapping({"/forStudent"})

	public String forStudent() {
		return "this is for Student";
	}
	@GetMapping({"/forLocataire"})
	@PreAuthorize("hasRole('Admin')")
	public String forLocataire() {
		return "this is for locataire";
	}
	
	
	
}
