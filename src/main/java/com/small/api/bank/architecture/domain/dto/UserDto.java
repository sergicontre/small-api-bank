package com.small.api.bank.architecture.domain.dto;

import com.small.api.bank.architecture.domain.model.User;

import lombok.Data;

@Data
public class UserDto {

	private String userId;
    private String name;
    private String password;
    
    
    public UserDto(String userId, String name, String password) {
		this.userId = userId;
		this.name = name;
		this.password = password;
	}
    
    
    public static UserDto valueOf(User user) {
        return new UserDto(
                user.getUserId(),
                user.getName(),
                user.getPassword()
        );
    }
    
    public User mapToUser() {
        return new User(userId, name, password);
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
	public String toString() {
		return "UserDto [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}
    
    
}
