package com.example.finalexamro37.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GroupNameNotExistsValidate.class)
public @interface GroupNameNotExists {
    String message() default "Group name exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
