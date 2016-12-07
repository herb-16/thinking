package com.bbkb.custom;

import com.bbkb.test.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/18<br>
 */
/*
* 定义约束验证器
* */
public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

    private CheckCase checkCase;

    @Override
    public void initialize(CheckCase checkCase) {
        this.checkCase = checkCase;
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        if (string == null){
            return true;
        }
        if (checkCase.value() == CaseMode.UPPER){
            return string.equals(string.toUpperCase());
        }else {
            return string.equals(string.toLowerCase());
        }
    }
}
