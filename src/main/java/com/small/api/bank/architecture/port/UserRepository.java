package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Port enable communication from application to database
 */
public interface UserRepository  extends JpaRepository<User, String>{

}