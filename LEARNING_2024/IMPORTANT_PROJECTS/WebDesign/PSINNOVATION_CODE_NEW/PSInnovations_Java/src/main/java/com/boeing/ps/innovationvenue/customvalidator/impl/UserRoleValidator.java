package com.boeing.ps.innovationvenue.customvalidator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.boeing.ps.innovationvenue.customvalidator.UserRoleConstraint;

public class UserRoleValidator implements ConstraintValidator<UserRoleConstraint, Integer>{

	 @Override
	 public void initialize(UserRoleConstraint userRole) {
	 
	 }
	 
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		List<Integer> roleIdList = new ArrayList<Integer>(Arrays.asList(0, 5, 10));
		return roleIdList.contains(value);
	}

}
