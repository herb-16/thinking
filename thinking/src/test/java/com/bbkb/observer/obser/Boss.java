package com.bbkb.observer.obser;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/5<br>
 */
public class Boss {

    public static void main(String[] args){
//        ISubject subject = new Secretary();
        WorkMate workMate = new WorkMate("workMate");
        WorkMate workMate1 = new WorkMate("workMate1");
        NBAMate nbaMate = new NBAMate("nbaFans");
//        subject.attach(workMate);
//        subject.attach(workMate1);
//        subject.attach(nbaMate);
//        subject.inform();
    }
}
