
package com.nisum.eventmanager.validation;

import org.springframework.stereotype.Component; 
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.nisum.eventmanager.model.AdminLoginModel;



/*
 * used for validating the login credentials
 */
@Component
public class Validation {
	
	public Validation() {
		// TODO Auto-generated constructor stub
	}

	public boolean supports(Class<?> c) {
		return AdminLoginModel.class.isAssignableFrom(c);
		
	}

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName","NotEmpty.loginForm.userName"); // for userName 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password","NotEmpty.loginForm.password");  // for password
	
	}
	

	
}
