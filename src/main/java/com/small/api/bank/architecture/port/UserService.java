package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.dto.UserDto;

/**
 * Port provides application functionality to the outside
 */
public interface UserService {

    UserDto getUserById(String userId);

    UserDto addUser(UserDto user);

}