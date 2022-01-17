package com.small.api.bank.architecture.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.port.UserService;
import com.small.api.bank.architecture.port.WalletService;

/**
 * The class defines a REST controller which is a primary adapter and invokes
 * the inbound port of the application.
 */
@RestController
@CrossOrigin
public class WalletController {

	private WalletService walletService;

	private UserService userService;

	@Autowired
	public WalletController(WalletService walletService, UserService userService) {
		this.walletService = walletService;
		this.userService = userService;
	}

	@PostMapping("/wallet")
	public WalletDto addWallet() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDto user = this.userService.getUserById(userDetails.getUsername());
		WalletDto saved = this.walletService.createWallet(user);
		return saved;

	}

	@GetMapping("/wallet/{address}")
	public WalletDto getWalletByAddress(@PathVariable String address) {
		WalletDto wallet = this.walletService.getWalletByAddress(address);
		if (wallet == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wallet not found");
		}
		return wallet;
	}
}
