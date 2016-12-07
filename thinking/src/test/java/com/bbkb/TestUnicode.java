package com.bbkb;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/24<br>
 */
public class TestUnicode {
    @Test
    public void testEscape(){
        String value =  "你好,联想";
        String valueUnicode = StringEscapeUtils.escapeJava(value);
        System.out.println("转义:"+valueUnicode);
        System.out.println("反转义:"+StringEscapeUtils.unescapeJava(valueUnicode));

    }

    @Test
    public void testConvert(){
        String s = "01:30";
        System.out.println( s.substring(0,2));
        System.out.println( s.substring(3,5));
        System.out.println("00".compareTo("01"));
        System.out.println("00".compareTo("00"));
    }
}
