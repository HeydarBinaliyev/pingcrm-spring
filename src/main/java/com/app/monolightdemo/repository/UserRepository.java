package com.app.monolightdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.monolightdemo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> , UserRepositoryCustom {

	Optional<User> findByEmail(String email);
	
}
