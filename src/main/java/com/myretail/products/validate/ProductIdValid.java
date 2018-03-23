package com.myretail.products.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductIdValidator.class)
public @interface ProductIdValid {
    String message() default "Invalid ProductId";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
