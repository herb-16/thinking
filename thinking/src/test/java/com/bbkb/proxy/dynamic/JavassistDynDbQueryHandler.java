package com.bbkb.proxy.dynamic;

import com.bbkb.proxy.*;
import com.bbkb.proxy.DBQuery;
import javassist.util.proxy.MethodHandler;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.Method;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;
    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }
}
