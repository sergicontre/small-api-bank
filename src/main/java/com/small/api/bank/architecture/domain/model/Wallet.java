package com.small.api.bank.architecture.domain.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.CascadeType.*;


import lombok.Data;

@Entity
@Table(name = "wallet")
@Data
public class Wallet {
	
	@Id
    private String address;
    private double balance;
    
    @ManyToOne(cascade = {DETACH, MERGE, PERSIST, REFRESH})
    @JoinColumn(name = "userId")
    private User user;
    
    public Wallet() {
        super();
    }
    
	public Wallet(String address, double balance, User user) {
		super();
		this.address = address;
		this.balance = balance;
		this.user = user;
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
	public int hashCode() {
		return Objects.hash(address, balance);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		return Objects.equals(address, other.address) && Objects.equals(balance, other.balance);
	}


	



    
}
