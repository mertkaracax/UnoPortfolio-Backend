package com.uno.portfolio.DTO;

import org.springframework.stereotype.Component;

@Component
public class LoginResponseDTO {
	private boolean isUsernameExists ; 
	private boolean isPasswordMatch;
	private boolean isUsernameCorrectForm;
	private boolean isPasswordCorrectForm;
	public LoginResponseDTO(boolean isUsernameExists, boolean isPasswordMatch, boolean isUsernameCorrectForm,
			boolean isPasswordCorrectForm) {
		super();
		this.isUsernameExists = isUsernameExists;
		this.isPasswordMatch = isPasswordMatch;
		this.isUsernameCorrectForm = isUsernameCorrectForm;
		this.isPasswordCorrectForm = isPasswordCorrectForm;
	}
	public LoginResponseDTO() {
		super();
	}
	
	
	public void setInvalidUsernameForm() {
		this.isUsernameCorrectForm = false;
		
	}
	public void setInvalidPasswordForm() {
		this.isUsernameCorrectForm = true;
		this.isPasswordCorrectForm = false;
		
	}
	public void setNonPresentUsername() {
		this.isUsernameCorrectForm = true;
		this.isPasswordCorrectForm = true;
		this.isUsernameExists = false;
	}
	
	public void setIncorrectPassword() {
		this.isUsernameCorrectForm = true;
		this.isPasswordCorrectForm = true;
		this.isUsernameExists = true;
		this.isPasswordMatch = false;
	}
	
	public void setSuccessfulLogin() {
		this.isUsernameCorrectForm = true;
		this.isPasswordCorrectForm = true;
		this.isUsernameExists = true;
		this.isPasswordMatch = true;
	}
	
	public boolean isLoginSuccessful() {
		return isUsernameCorrectForm && isPasswordCorrectForm && isUsernameExists && isPasswordMatch;
	}
	

}
