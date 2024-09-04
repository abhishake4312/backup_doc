package com.boeing.ps.innovationvenue.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.boeing.ps.innovationvenue.customvalidator.impl.UserRoleValidator;

@Documented
@Constraint(validatedBy = UserRoleValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UserRoleConstraint {
    String message() default "Invalid Role information";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}