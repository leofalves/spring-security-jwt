package io.leofalves.springsecurityjwt.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.leofalves.springsecurityjwt.entities.UserAuthenticated;
import io.leofalves.springsecurityjwt.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username)
				.map(UserAuthenticated::new)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}
}
