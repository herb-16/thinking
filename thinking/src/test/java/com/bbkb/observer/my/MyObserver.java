package com.bbkb.observer.my;

import java.util.Observable;
import java.util.Observer;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class MyObserver implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("调用observer观察者");
    }
    //// TODO: 2016/11/22 观察者模式理解
    /*
    * 观察者模式
    * */
}
