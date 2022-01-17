package com.small.api.bank.architecture.domain.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.port.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDto user = userService.getUserById(username);
		
		if( user != null) {
			return new User(user.getUserId(), user.getPassword(),
			        new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
		
	} 

}