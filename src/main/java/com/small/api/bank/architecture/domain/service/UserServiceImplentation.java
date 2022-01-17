package com.small.api.bank.architecture.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.model.User;
import com.small.api.bank.architecture.port.UserRepository;
import com.small.api.bank.architecture.port.UserService;

import lombok.RequiredArgsConstructor;


/**
 * Implementation of UserService port.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImplentation implements UserService {

	@Autowired
    private UserRepository userRepository;
        
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
	@Override
	public UserDto getUserById(String userId) {
		
		UserDto userDto = null;

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
        	userDto = UserDto.valueOf(optionalUser.get());
        }
        
		return userDto;
		 
	}

	@Override
	public UserDto addUser(UserDto userDto) {
		
		    String userId = userDto.getUserId();
	        
	        User user = userDto.mapToUser();
	        UserDto saved = null;

	        if (userRepository.findById(userId).orElse(null) == null) {
	        	user.setPassword(encoder().encode(userDto.getPassword()));
	            saved = UserDto.valueOf(userRepository.save(user));
	        
	        }
	        
	        return saved;
	}
	
}
