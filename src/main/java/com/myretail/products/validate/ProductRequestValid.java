package com.myretail.products.validate;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductRequestValidator.class)
public @interface ProductRequestValid {
}
