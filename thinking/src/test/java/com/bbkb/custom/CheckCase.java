package com.bbkb.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/18<br>
 */

/**
 * 验证规则
 */
@Target({ElementType.METHOD,ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
public @interface CheckCase {
//    @interface 自定义的注解
    String message() default "{key} must be {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD,ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List{
        CheckCase[] value();
    }
    String key() default "";

    CaseMode value();
}


/*
* 1、自定义验证规则
* 2、定义约束验证器
*
* */