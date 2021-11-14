package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appartementlocation.projet.models.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
