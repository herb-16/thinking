package com.bbkb.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class HelloClient {
    public static void main(String args[]){
        try {
            //在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
            IHello rhello =(IHello) Naming.lookup("rmi://localhost:8888/RHello");
            System.out.println(rhello.helloWorld());
            System.out.println(rhello.sayHelloToSomeBody("熔岩"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
