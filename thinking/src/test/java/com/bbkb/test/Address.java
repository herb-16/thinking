package com.bbkb.test;

import javax.validation.constraints.NotNull;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/18<br>
 */
public class Address {

    @NotNull(message = "城市不能为空")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
