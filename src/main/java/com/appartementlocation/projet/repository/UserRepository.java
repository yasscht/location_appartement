package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appartementlocation.projet.models.User;

public interface UserRepository extends JpaRepository<User, String> {
User findByEmail(String email);
}
