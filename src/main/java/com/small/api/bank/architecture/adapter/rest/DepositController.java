package com.small.api.bank.architecture.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.small.api.bank.architecture.domain.dto.DepositDto;
import com.small.api.bank.architecture.domain.dto.DepositRequestDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.port.DepositService;
import com.small.api.bank.architecture.port.WalletService;

/**
 * The class defines a REST controller which is a primary adapter and invokes
 * the inbound port of the application.
 */
@RestController
@CrossOrigin
public class DepositController {


	private DepositService depositService;
	
	private WalletService walletService;

	@Autowired
	public DepositController(DepositService depositService, WalletService walletService) {
		this.depositService = depositService;
		this.walletService = walletService;
	}

	
	 @PostMapping("/deposit")
	    public ResponseEntity<?> addWallet(@RequestBody DepositRequestDto deposit) {
		 	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			WalletDto wallet = this.walletService.getWalletByUserId(userDetails.getUsername());
	        
			DepositDto depositDto = new DepositDto(null, null, deposit.getAmount(), wallet.mapToWallet());
			
			DepositDto saved = this.depositService.addDeposit(depositDto);
	        if (saved == null) {
	            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Deposit failed");
	        }
	        return new ResponseEntity<>(saved,HttpStatus.CREATED);
	    	
	    }

}
