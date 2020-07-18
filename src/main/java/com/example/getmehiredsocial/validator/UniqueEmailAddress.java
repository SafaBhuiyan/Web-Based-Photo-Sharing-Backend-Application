package com.example.getmehiredsocial.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailAddressValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueEmailAddress {
    String message() default "Email Address already being used";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
