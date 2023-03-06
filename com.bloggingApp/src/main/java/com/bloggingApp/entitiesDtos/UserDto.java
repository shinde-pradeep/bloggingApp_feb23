package com.bloggingApp.entitiesDtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

	
	private long userId;
	
	
	@NotBlank
	@Length(min=3, max=225, message = "user name  length should be min-3 & max-225")
	private String userName;
	
	@NotBlank
    @Email (message = "please enter valid email")
	private String userMail;
	
	@NotBlank
	@Length(min=3, max=225, message = "user password  length should be min-3 & max-225")
	private String userPassword;
	
	@NotBlank
	@Length(min=3, max=225, message = "user info should contains min-3 & max-225 characters")
	private String userAbout;

	
//NoArgsConstructor.....................................................
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//Getter and Setter......................................................
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}
	
	
	
	
}
