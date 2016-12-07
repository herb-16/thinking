package com.bbkb.observer;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class ConcreteSubject implements ISubject{
    Vector<IObserver> observers = new Vector<IObserver>();

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void dcattach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void inform() {
        Event event = new Event();
        for (IObserver o :
                observers) {
            o.update(event);
        }
    }
}
