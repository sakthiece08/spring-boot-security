package com.teqmonic.jpasecurity.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teqmonic.jpasecurity.model.UserSecurity;
import com.teqmonic.jpasecurity.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JPAUserDetailsService implements UserDetailsService {

	private final UserRepository userResRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return Optional.ofNullable(username)
				.flatMap(userResRepository::findByUserName)
				.map(UserSecurity::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found for the given username: " + username));
	}

}
