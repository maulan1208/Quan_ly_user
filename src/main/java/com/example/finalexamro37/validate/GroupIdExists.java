package com.example.finalexamro37.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GroupIdExistsValidator.class)
public @interface GroupIdExists {
    String message() default "Group id not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
