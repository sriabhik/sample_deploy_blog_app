package com.blogapplication.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapplication.entities.User;
import org.springframework.data.repository.NoRepositoryBean;


public interface UserRepo extends JpaRepository<User,Integer> {
	Optional<User> findByEmail(String email);

}
