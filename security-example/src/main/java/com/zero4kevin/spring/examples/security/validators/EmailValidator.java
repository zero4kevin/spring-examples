package com.zero4kevin.spring.examples.security.validators;

import com.zero4kevin.spring.examples.security.annotations.ValidEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kevin on 2/13/18.
 */
public class EmailValidator implements ConstraintValidator<ValidEmail, String>{

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z{2,})$";

    @Override
    public void initialize(ValidEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return validateEmail(s);
    }
    private boolean validateEmail(String s){
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(s);
        return matcher.matches();
    }
}
