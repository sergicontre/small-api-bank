package com.small.api.bank.architecture.domain.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.api.bank.architecture.domain.dto.DepositDto;
import com.small.api.bank.architecture.domain.dto.TransferDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.domain.model.Deposit;
import com.small.api.bank.architecture.domain.model.Transfer;
import com.small.api.bank.architecture.domain.model.Wallet;
import com.small.api.bank.architecture.port.DepositRepository;
import com.small.api.bank.architecture.port.DepositService;
import com.small.api.bank.architecture.port.TransferRepository;
import com.small.api.bank.architecture.port.TransferService;
import com.small.api.bank.architecture.port.WalletRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferServiceImplementation implements TransferService {
	
	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	private WalletRepository walletRepository;

	@Override
	public TransferDto doTransfer(TransferDto transferDto) throws Exception {
		
		UUID uuid = UUID.randomUUID();
		
		Wallet walletFrom = walletRepository.getById(transferDto.getFrom());
		Wallet walletTo = walletRepository.getById(transferDto.getTo());
		
		
		double balanceWalletFrom = walletFrom.getBalance();
		if(balanceWalletFrom < transferDto.getAmount()) {
			throw new Exception("Balance in from wallet not sufficient");
		}
		
		double balanceWalletTo = walletTo.getBalance();
		walletTo.setBalance(balanceWalletTo + transferDto.getAmount());
		walletFrom.setBalance(balanceWalletFrom - transferDto.getAmount());
		
		walletRepository.save(walletFrom);
		walletRepository.save(walletTo);
		
        Transfer transfer = new Transfer(uuid.toString(), transferDto.getFrom(), transferDto.getTo(), transferDto.getAmount(), new Date());
        
        TransferDto saved = null;

        if (transferRepository.findById(transfer.getId()).orElse(null) == null) {
            saved = TransferDto.valueOf(transferRepository.save(transfer));
        }
          
        return saved;
		
	}
	 	 
	
}
