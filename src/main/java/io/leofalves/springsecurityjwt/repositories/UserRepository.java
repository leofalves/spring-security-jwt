package io.leofalves.springsecurityjwt.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import io.leofalves.springsecurityjwt.entities.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	Optional<User> findByUsername(String username);

}