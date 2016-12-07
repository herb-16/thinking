package com.bbkb.proxy.dynamic;

import com.bbkb.proxy.IDBQuery;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class DBQuery implements IDBQuery{
    public DBQuery() {
//        try {
//            Thread.sleep(10);
//            System.out.println("invoke DBQuery");
//        } catch (InterruptedException e) {
//            System.out.println("invoke failed");
//            e.printStackTrace();
//        }
    }

    @Override
    public String request() {
        return "hello";
    }
}
