package com.zupacademy.italo.mercadolivre.utilidades;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExisteIdValidator.class})
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ExisteId {

    String message() default "{com.deveficiente.beanvalidation.existsid}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    String fieldName();
    Class<?> domainClass();
}
