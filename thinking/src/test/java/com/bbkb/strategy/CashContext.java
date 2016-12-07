package com.bbkb.strategy;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class CashContext {
//    private CashSuper cashSuper;

//    public CashContext(CashSuper cashSuper) {
//        this.cashSuper = cashSuper;
//    }
    private int type;

    public CashContext(int type) {
        this.type = type;
    }

    public static CashSuper createAccept(int type){
        CashSuper cashSuper = null;
        switch (type){
            case 0:
//                正常收费
                cashSuper = new CashNormal();
                break;
            case 1:
//                八折
                cashSuper = new CashRebate(0.8);
                break;
            case 2:
//                满300减100
                cashSuper = new CashReturn(300,100);
                break;
        }
        return cashSuper;
    }

    public double createCash(double money){
        return createAccept(type).acceptCash(money);
    }
    // TODO: 2016/12/6 简单工厂模式
}
