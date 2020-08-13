package com.strawhat.annotation.validate;

import com.strawhat.validate.DateTimeValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * 日期校验注解
 */
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {
    String message() default "日期格式错误";
    String format() default "yyyyMMddHHmmss";
    boolean required() default false;


}
