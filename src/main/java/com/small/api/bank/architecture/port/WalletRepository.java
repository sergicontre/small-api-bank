package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.model.Wallet;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Port enable communication from application to database
 */
public interface WalletRepository extends JpaRepository<Wallet, String>{
	
	Optional<Wallet> findWalletByUser_UserId(String userId);
}