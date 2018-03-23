package com.myretail.products.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductRequestValidator  implements ConstraintValidator<ProductIdValid, Object[]> {

    @Override
    public void initialize(ProductIdValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }
}
