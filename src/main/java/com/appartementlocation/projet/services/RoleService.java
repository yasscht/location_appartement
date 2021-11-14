package com.appartementlocation.projet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Role;
import com.appartementlocation.projet.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;
   public Role createNewRole(Role role) {
	   return roleRepository.save(role);
   }
}
