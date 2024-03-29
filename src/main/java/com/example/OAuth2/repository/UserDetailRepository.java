package com.example.OAuth2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.OAuth2.model.User;



public interface UserDetailRepository extends JpaRepository<User, Integer>{
	
	
	Optional<User> findByUsername(String name);

}
