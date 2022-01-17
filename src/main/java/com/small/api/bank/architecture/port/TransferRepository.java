package com.small.api.bank.architecture.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.small.api.bank.architecture.domain.model.Transfer;

/**
 * Port enable communication from application to database
 */
public interface TransferRepository extends JpaRepository<Transfer, String>{
	
}