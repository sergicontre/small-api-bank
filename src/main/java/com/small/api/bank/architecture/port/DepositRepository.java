package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.model.Deposit;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Port enable communication from application to database
 */
public interface DepositRepository extends JpaRepository<Deposit, String>{
	
	Optional<Deposit> findDepositByWallet_Address(String address);
}