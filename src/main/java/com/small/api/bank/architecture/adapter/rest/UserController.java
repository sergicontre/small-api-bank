package com.small.api.bank.architecture.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.small.api.bank.architecture.config.JwtTokenUtil;
import com.small.api.bank.architecture.domain.dto.JwtRequestDto;
import com.small.api.bank.architecture.domain.dto.JwtResponseDto;
import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.service.JwtUserDetailsService;
import com.small.api.bank.architecture.port.UserService;

/**
 * The class defines a REST controller which is a primary adapter and invokes the inbound port of the application.
 */
@RestController
@CrossOrigin
public class UserController {

    private UserService userService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserController(UserService userService ) {
        this.userService = userService;
        
    }
  

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
    	 UserDto user = userService.getUserById(userId);
         if (user == null) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
         }
         return user;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
    	
        UserDto saved = userService.addUser(user);
        if (saved == null) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "User already exists");
        }
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    	
    }
   
    @PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) throws Exception {

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		if(encoder().matches(authenticationRequest.getPassword(), userDetails.getPassword())) {
			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponseDto(token));
			
		} else {
			 throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User without permissions to authenticate");
		}
		
		
	}

	
    

}
