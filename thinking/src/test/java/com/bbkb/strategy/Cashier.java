package com.bbkb.strategy;

import javax.swing.*;
import java.awt.*;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class Cashier extends JFrame{
    private double univalent;
    private int count;
//    private double total = 0.0d;
//
//    private double discount ;
//
//    public void calculate(double discount){
//        total += univalent * count * discount;
//    }


    public static void main(String[] args){
//        CashSuper cashSuper = DiscountFactory.createAccept(2);
//        策略模式
//        CashSuper cashSuper = new CashRebate(0.6);
//        CashContext cashContext = new CashContext(cashSuper);

//        将工厂模式和策略模式结合

        CashContext cashContext = new CashContext(1);
        double univalent = 19d;
        int count = 19;
        System.out.println("实际应付价格: "+cashContext.createCash(univalent*count));

    }


}
