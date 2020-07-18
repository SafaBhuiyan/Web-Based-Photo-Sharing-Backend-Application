package com.example.getmehiredsocial.ValidatorAlbum;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = UniqueCoverPhotoUrlValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface UniqueCoverPhotoUrl {
    String message() default "Cover Photo Already Exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}

