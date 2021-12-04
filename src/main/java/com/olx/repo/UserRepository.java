package com.olx.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olx.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	// UserEntity findByAuthToken(String authToken);

	 UserEntity findByUsername(String username);
	 
	// List<UserEntity> findByUsernameAll(String username);
}
