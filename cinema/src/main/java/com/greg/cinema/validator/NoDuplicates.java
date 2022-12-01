package com.greg.cinema.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.greg.cinema.constant.ErrorMessages;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = NoDuplicatesValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoDuplicates {
	String message() default ErrorMessages.INVALID_DATA_PROVIDED;
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
