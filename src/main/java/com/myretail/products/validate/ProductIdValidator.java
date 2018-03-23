package com.myretail.products.validate;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * ProductIdValidator is a custom validator that helps to receive valid ProductID from request.
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class ProductIdValidator implements ConstraintValidator<ProductIdValid, String> {
    @Override
    public void initialize(ProductIdValid constraintAnnotation) {
        // No Implementation required
    }

    @Override
    public boolean isValid(String productId, ConstraintValidatorContext constraintValidatorContext) {
        return productId.chars().allMatch( Character::isDigit );
    }
}
