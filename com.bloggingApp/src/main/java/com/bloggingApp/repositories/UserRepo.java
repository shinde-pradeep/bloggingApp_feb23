package com.bloggingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.entities.User;

public interface UserRepo extends JpaRepository<User, Long> {

	
	
	
}
