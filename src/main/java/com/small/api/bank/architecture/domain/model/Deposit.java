package com.small.api.bank.architecture.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.*;


import lombok.Data;

@Entity
@Table(name = "deposit")
@Data
public class Deposit {
	
	public Deposit(String id, Date date, double amount, Wallet wallet) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.wallet = wallet;
	}

	@Id
	private String id;
    private Date date;
    private double amount;
    
    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "address")
    private Wallet wallet;
    
    public Deposit() {
        super();
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
	public int hashCode() {
		return Objects.hash(amount, date, id, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deposit other = (Deposit) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(wallet, other.wallet);
	}
        
}
