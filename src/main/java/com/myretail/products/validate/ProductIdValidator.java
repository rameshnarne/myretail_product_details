package com.myretail.products.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ProductIdValidator implements ConstraintValidator<ProductIdValid, Object[]> {
    @Override
    public void initialize(ProductIdValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        return objects[0].toString().chars().allMatch( Character::isDigit );
    }
}
