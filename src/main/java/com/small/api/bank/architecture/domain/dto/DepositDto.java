package com.small.api.bank.architecture.domain.dto;

import java.util.Date;

import com.small.api.bank.architecture.domain.model.Deposit;
import com.small.api.bank.architecture.domain.model.Wallet;

import lombok.Data;

@Data
public class DepositDto {

	private String id;
	private Date date;
    private double amount;
    private Wallet wallet;
        
    public DepositDto(String id, Date date, double amount, Wallet wallet) {
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.wallet = wallet;
	}
    
    
    public static DepositDto valueOf(Deposit deposit) {
        return new DepositDto(
                deposit.getId(),
                deposit.getDate(),
                deposit.getAmount(),
                deposit.getWallet()
        );
    }
    
    public Deposit mapToDeposit() {
        return new Deposit(id, date, amount, wallet);
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}


	@Override
	public String toString() {
		return "DepositDto [id=" + id + ", date=" + date + ", amount=" + amount + ", wallet=" + wallet + "]";
	}
	
}
