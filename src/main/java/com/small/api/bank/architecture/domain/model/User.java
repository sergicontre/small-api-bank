package com.small.api.bank.architecture.domain.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
		
		@Id
	    private String userId;
	    private String name;
	    private String password;


	    public User() {
	        super();
	    }

	    public User(String userId, String name, String password) {
	        this.userId = userId;
	        this.name = name;
	        this.password = password;
	    }

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, password, userId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(name, other.name) && Objects.equals(password, other.password)
					&& Objects.equals(userId, other.userId);
		}

	   
}
