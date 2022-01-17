package com.small.api.bank.architecture.domain.dto;

import com.small.api.bank.architecture.domain.model.User;
import com.small.api.bank.architecture.domain.model.Wallet;

import lombok.Data;

@Data
public class WalletDto {

	private String address;
    private double balance;
    private User user;
        
    public WalletDto(String address, double balance, User user) {
		this.address = address;
		this.balance = balance;
		this.user = user;
	}
    
    
    public static WalletDto valueOf(Wallet wallet) {
        return new WalletDto(
                wallet.getAddress(),
                wallet.getBalance(),
                wallet.getUser()
        );
    }
    
    public Wallet mapToWallet() {
        return new Wallet(address, balance, user);
    }


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "WalletDto [address=" + address + ", balance=" + balance + ", user=" + user + "]";
	}
}
