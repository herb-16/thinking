package com.bbkb.strategy;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class CashRebate extends CashSuper{
    private double discount = 1d;

    public CashRebate(double discount) {
        this.discount = discount;
    }

    @Override
    public double acceptCash(double money) {
        return money*discount;
    }
}
