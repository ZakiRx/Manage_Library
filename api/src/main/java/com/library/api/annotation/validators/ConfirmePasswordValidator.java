package com.library.api.annotation.validators;

import com.library.api.annotation.ConfirmePassword;
import com.library.api.dto.AuthorDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmePasswordValidator implements ConstraintValidator<ConfirmePassword, String> {
  @Override
  public boolean isValid(String authorDTO, ConstraintValidatorContext constraintValidatorContext) {
//    String passowrd=authorDTO.getAuthorPassword();
//    String confirmePassowrd=authorDTO.getConfirmePassword();
//    System.out.println("passowrd : " +passowrd);
//    System.out.println("confirme : "+confirmePassowrd);
    return false;
  }
}
