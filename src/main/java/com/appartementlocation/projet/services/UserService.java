package com.appartementlocation.projet.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Role;
import com.appartementlocation.projet.models.User;
import com.appartementlocation.projet.repository.RoleRepository;
import com.appartementlocation.projet.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public void initRolesAndUser() {
		Role locataireRole=new Role();
		
		locataireRole.setRoleName("Admin");
		locataireRole.setRoleDescription("Locataire Role");
		
		roleRepository.save(locataireRole);
		
	Role etudiantRole=new Role();
		
	etudiantRole.setRoleName("User");
	etudiantRole.setRoleDescription("Etudiant Role");
		roleRepository.save(etudiantRole);
		
		User etudiant=new User();
		etudiant.setUserName("yassine.chtiaa@gmail.com");
		etudiant.setEmail("yassine.chtiaa@gmail.com");
		etudiant.setFirstName("Yassine");
		etudiant.setLastName("chtiaa");
		etudiant.setPassword(getEncodedPassword("yassine02"));
	
		
		Set<Role> etudiantRoles=new HashSet<>();
		etudiantRoles.add(etudiantRole);
		etudiant.setRole(etudiantRoles);
		userRepository.save(etudiant);
		
		User locataire=new User();
		locataire.setUserName("malak.ba3roura@gmail.com");
		locataire.setEmail("malak.ba3roura@gmail.com");
		locataire.setFirstName("malak");
		locataire.setLastName("ba3roura");
		locataire.setPassword(getEncodedPassword("malak02"));
		
		Set<Role> locataireRoles=new HashSet<>();
	locataireRoles.add(locataireRole);
	locataire.setRole(locataireRoles);
		userRepository.save(locataire);
		
		
		User admin=new User();
		admin.setUserName("soufianchabou@gmail.com");
		admin.setEmail("soufianchabou@gmail.com");
		admin.setFirstName("Soufian");
		admin.setLastName("chabou");
		admin.setPassword(getEncodedPassword("1234"));
		
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(locataireRole);
		admin.setRole(adminRoles);
		userRepository.save(admin);
		
		
	
		
		
		
	}
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
