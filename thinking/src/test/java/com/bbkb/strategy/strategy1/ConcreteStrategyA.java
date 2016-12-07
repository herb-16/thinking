package com.bbkb.strategy.strategy1;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class ConcreteStrategyA extends Strategy {
    @Override
    public void Algorithm() {
        System.out.println("A 方法");
    }
}
