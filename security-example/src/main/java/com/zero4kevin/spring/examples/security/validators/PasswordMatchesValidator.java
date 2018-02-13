package com.zero4kevin.spring.examples.security.validators;

import com.zero4kevin.spring.examples.security.DTO.UserDTO;
import com.zero4kevin.spring.examples.security.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kevin on 2/13/18.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {


    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        UserDTO user=(UserDTO) o;
        return user.getPassword().equals(user.getConfirmPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
}
