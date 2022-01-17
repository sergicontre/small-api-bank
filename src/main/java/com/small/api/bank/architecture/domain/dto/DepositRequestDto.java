package com.small.api.bank.architecture.domain.dto;

import java.io.Serializable;


public class DepositRequestDto implements Serializable {

	private static final long serialVersionUID = -753662087311271834L;

	private double amount;
	

	public DepositRequestDto() {

	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}