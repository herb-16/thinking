package com.bbkb.proxy.dynamic;

import com.bbkb.proxy.*;
import javassist.*;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import net.sf.cglib.proxy.Enhancer;
import java.lang.reflect.Proxy;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class FunctionMain {


    public static void main(String[] args){
        IDBQuery idbQuery = null;
        idbQuery = createJdkProxy();
        System.out.println("createJdkProxy:");
        System.out.println(idbQuery.request());
        idbQuery = createCglibProxy();
        System.out.println("createCglibProxy:");
        System.out.println(idbQuery.request());
        try {
            idbQuery = createJavassistDynProxy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("createJavassistDynProxy:");
        System.out.println(idbQuery.request());
        try {
            idbQuery = createJavassistBytecodeDynamicProxy();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        System.out.println("createJavassistBytecodeDynamicProxy:");
        System.out.println(idbQuery.request());

    }

    public static IDBQuery createJdkProxy(){
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery.class},new JdkDbQueryHandler());
        return jdkProxy;
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibDbQueryInterceptor());
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();
        return cglibProxy;
    }

    public static IDBQuery createJavassistDynProxy()throws Exception{
//            代理工厂
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
            Class proxyClass = proxyFactory.createClass();
            IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
            ((ProxyObject)javassistProxy).setHandler(new JavassistDynDbQueryHandler());
            return javassistProxy;
    }

    public static IDBQuery createJavassistBytecodeDynamicProxy() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException {
        ClassPool classPool = new ClassPool(true);
//        定义类名
        CtClass ctClass = classPool.makeClass(IDBQuery.class.getName()+"Javassist-BytecodeProxy");
//        需要实现的接口
        ctClass.addInterface(classPool.get(IDBQuery.class.getName()));
//        添加构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
//        添加类的字段信息,使用动态java代码
        ctClass.addMethod(CtNewMethod.make("public String request() { if(real==null)real=new "+DBQuery.class.getName()+"();return real.request(); }",ctClass));
        Class pc = ctClass.toClass();
        IDBQuery byteCodeProxy = (IDBQuery) pc.newInstance();
        return byteCodeProxy;
    }
}
