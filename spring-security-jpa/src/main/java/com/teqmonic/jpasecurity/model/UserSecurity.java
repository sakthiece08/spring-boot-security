package com.teqmonic.jpasecurity.model;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.teqmonic.jpasecurity.entity.User;


public class UserSecurity implements UserDetails{
		
	private static final long serialVersionUID = 6535125993258754516L;
	
	private User user;
	
	public UserSecurity(User user) {
		this.user = user;
	}
	
	@Override
	public String getUsername() {
		return user.getUserName();
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.toList();
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
