package com.myretail.products.validate;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductIdValidator.class)
public @interface ProductIdValid {
}
