package com.small.api.bank.architecture.port;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;

/**
 * Port provides application functionality to the outside
 */
public interface WalletService {

    WalletDto getWalletByUserId(String userId);

    WalletDto createWallet(UserDto user);
    
    WalletDto getWalletByAddress(String address);

}