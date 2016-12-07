package com.bbkb.observer.obser;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/5<br>
 */
public class Secretary implements ISubject{
//    List<IObserver> workMates = new ArrayList<IObserver>();
    public EventHandler Update;
    private String action;

//    public void attach(IObserver workMate){
//        workMates.add(workMate);
//    }
//
//    public void dcattach(IObserver workMate){
//        workMates.remove(workMate);
//    }

    public void inform(){
//        Update;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
