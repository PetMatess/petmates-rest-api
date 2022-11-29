/*package edu.estu.petmates.user;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({   ElementType.FIELD   })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {
    String message() default "e-mail must be unique";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
*/