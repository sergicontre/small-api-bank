package com.small.api.bank.architecture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.small.api.bank.architecture.domain.dto.UserDto;
import com.small.api.bank.architecture.domain.dto.WalletDto;
import com.small.api.bank.architecture.port.WalletService;

@SpringBootTest
class WalletServiceUnitTest {

	@Autowired
	WalletService walletService;

	@Test
	void createWalletTest() {
		UserDto user = new UserDto("sergio", "sergioCM", "12345");

		walletService.createWallet(user);
		WalletDto walletFound = walletService.getWalletByUserId(user.getUserId());

		assertNotNull(walletFound);
	}
}