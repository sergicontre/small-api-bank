package com.small.api.bank.architecture;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.port.UserService;


@SpringBootTest
class UserServiceUnitTest {

	@Autowired
	UserService userService;
	
	@Test
	void addUserTest() {
	        UserDto user = new UserDto("sergio", "sergioCM", "12345");
	        userService.addUser(user);
	        UserDto userFound = userService.getUserById("sergio");
	        assertNotNull(userFound);	
	}
}