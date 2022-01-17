package com.small.api.bank.architecture.domain.dto;

import java.util.Date;

import com.small.api.bank.architecture.domain.model.Transfer;

import lombok.Data;

@Data
public class TransferDto {
	
	public TransferDto(String id, String from, String to, double amount, Date date) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.amount = amount;
		this.date = date;
	}

	private String id;
    private String from;
    private String to;
    private double amount;
    private Date date;
    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
    
	 public static TransferDto valueOf(Transfer transfer) {
	        return new TransferDto(
	                transfer.getId(),
	                transfer.getWalletFrom(),
	                transfer.getWalletTo(),
	                transfer.getAmount(),
	                transfer.getDate()
	        );
	    }
	
	public Transfer mapToTransfer() {
	        return new  Transfer(id, from, to, amount, date);
	}
	
	@Override
	public String toString() {
		return "TransferDto [id=" + id + ", from=" + from + ", to=" + to + ", amount=" + amount + ", date=" + date
				+ "]";
	}
	
}
