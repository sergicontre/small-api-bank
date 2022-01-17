package com.small.api.bank.architecture.domain.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.api.bank.architecture.domain.dto.DepositDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.domain.model.Deposit;
import com.small.api.bank.architecture.domain.model.Wallet;
import com.small.api.bank.architecture.port.DepositRepository;
import com.small.api.bank.architecture.port.DepositService;
import com.small.api.bank.architecture.port.WalletRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepositServiceImplementation implements DepositService {
	
	@Autowired
	private DepositRepository depositRepository;
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public DepositDto addDeposit(DepositDto depositDto) {
		
		UUID uuid = UUID.randomUUID();
		
		Wallet wallet = depositDto.getWallet();
		double walletBalance = wallet.getBalance();
		double newWalletBalance = walletBalance + depositDto.getAmount();
		wallet.setBalance(newWalletBalance);
		
		walletRepository.save(wallet);
		
        Deposit deposit = new Deposit(uuid.toString(), new Date(), depositDto.getAmount(), depositDto.getWallet());
        
        DepositDto saved = null;

        if (depositRepository.findById(deposit.getId()).orElse(null) == null) {
            saved = DepositDto.valueOf(depositRepository.save(deposit));
        }
          
        return saved;
		
	}
	 	 
	
}
