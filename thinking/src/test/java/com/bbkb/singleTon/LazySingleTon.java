package com.bbkb.singleTon;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/21<br>
 */
public class LazySingleTon {
    private static LazySingleTon lazySingleTon;

    private LazySingleTon() {
        System.out.println("lazySingleTon is create");
    }

    public static LazySingleTon getInstance(){
        synchronized (LazySingleTon.class){
            if (lazySingleTon == null){
                lazySingleTon = new LazySingleTon();
            }
            return lazySingleTon;
        }
    }
}
