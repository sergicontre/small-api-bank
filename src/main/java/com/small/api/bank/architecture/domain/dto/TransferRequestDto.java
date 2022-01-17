package com.small.api.bank.architecture.domain.dto;

import java.io.Serializable;


public class TransferRequestDto implements Serializable {

	private static final long serialVersionUID = -753662087311271834L;

	private double amount;
	private String from;
	private String to;
	
	

	public TransferRequestDto(double amount, String from, String to) {
		super();
		this.amount = amount;
		this.from = from;
		this.to = to;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}