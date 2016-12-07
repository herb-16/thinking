package com.bbkb.proxy.dynamic;

import com.bbkb.proxy.DBQuery;
import com.bbkb.proxy.IDBQuery;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }
}
