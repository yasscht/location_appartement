package com.appartementlocation.projet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appartementlocation.projet.models.Role;
import com.appartementlocation.projet.services.RoleService;

@RestController
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@PostMapping({"/createNewRole"})
	public Role createNewRole(@RequestBody Role role) {
		
		return roleService.createNewRole(role);
		
		
	}

}
