package com.small.api.bank.architecture.domain.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.domain.model.Wallet;
import com.small.api.bank.architecture.port.WalletRepository;
import com.small.api.bank.architecture.port.WalletService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletServiceImplementation implements WalletService {
	
	@Autowired
	private WalletRepository walletRepository;
	 	 
	@Override
	public WalletDto getWalletByUserId(String userId) {
	
		
		WalletDto walletDto = null;

        Optional<Wallet> optionalWallet = walletRepository.findWalletByUser_UserId(userId);
        if (optionalWallet.isPresent()) {
        	walletDto = WalletDto.valueOf(optionalWallet.get());
        }
        
		return walletDto;
		
	}
	
	@Override
	public WalletDto getWalletByAddress(String address) {
		
		WalletDto walletDto = null;

        Optional<Wallet> optionalWallet = walletRepository.findById(address);
        if (optionalWallet.isPresent()) {
        	walletDto = WalletDto.valueOf(optionalWallet.get());
        }
        
		return walletDto;
		 
	}

	@Override
	public WalletDto createWallet(UserDto user) {
			
			UUID uuid = UUID.randomUUID();
			
	        Wallet wallet = new Wallet(uuid.toString(), 0, user.mapToUser());
	        
	        WalletDto saved = null;

	        if (walletRepository.findById(wallet.getAddress()).orElse(null) == null) {
	            saved = WalletDto.valueOf(walletRepository.save(wallet));
	        }
	          
	        return saved;
	}


}
