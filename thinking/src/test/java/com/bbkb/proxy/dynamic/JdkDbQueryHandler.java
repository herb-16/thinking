package com.bbkb.proxy.dynamic;

import com.bbkb.proxy.DBQuery;
import com.bbkb.proxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class JdkDbQueryHandler implements InvocationHandler{
    IDBQuery real = null;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }


}
