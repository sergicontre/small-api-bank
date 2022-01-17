package com.small.api.bank.architecture.domain.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "transfer")
@Data
public class Transfer {
		
		@Id
		private String idTransfer;
	    private String walletFrom;
	    private String walletTo;
	    private double amount;
	    private Date date;
	    
	    public Transfer(String id, String walletFrom, String walletTo, double amount, Date date) {
			super();
			this.idTransfer = id;
			this.walletFrom = walletFrom;
			this.walletTo = walletTo;
			this.amount = amount;
			this.date = date;
		}

	    public Transfer() {
	        super();
	    }


		public String getId() {
			return idTransfer;
		}


		public void setId(String id) {
			this.idTransfer = id;
		}

		public String getIdTransfer() {
			return idTransfer;
		}

		public void setIdTransfer(String idTransfer) {
			this.idTransfer = idTransfer;
		}

		public String getWalletFrom() {
			return walletFrom;
		}

		public void setWalletFrom(String walletFrom) {
			this.walletFrom = walletFrom;
		}

		public String getWalletTo() {
			return walletTo;
		}

		public void setWalletTo(String walletTo) {
			this.walletTo = walletTo;
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

		@Override
		public int hashCode() {
			return Objects.hash(amount, date, idTransfer, walletFrom, walletTo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Transfer other = (Transfer) obj;
			return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
					&& Objects.equals(date, other.date) && Objects.equals(idTransfer, other.idTransfer)
					&& Objects.equals(walletFrom, other.walletFrom) && Objects.equals(walletTo, other.walletTo);
		}


}
