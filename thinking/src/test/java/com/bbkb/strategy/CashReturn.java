package com.bbkb.strategy;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class CashReturn extends CashSuper {

    private double condition;
    private double returnn;

    public CashReturn(double condition, double returnn) {
        this.condition = condition;
        this.returnn = returnn;
    }

    @Override
    public double acceptCash(double money) {
        if (money < condition){
            return money;
        }else {
            // TODO: 2016/12/6  和答案不一样
//            return money - returnn;
            return money - Math.floor(money/condition)*returnn;
        }
    }
}
