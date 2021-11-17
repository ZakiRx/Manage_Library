package com.library.api.annotation;

import com.library.api.annotation.validators.ConfirmePasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = ConfirmePasswordValidator.class)
public @interface ConfirmePassword {
  String message() default  "Passowrd not match";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

}
