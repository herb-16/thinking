package com.bbkb.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class HelloImpl extends UnicastRemoteObject implements IHello{
    public HelloImpl() throws RemoteException{
    }

    @Override
    public String helloWorld() throws RemoteException {
        return "Hello World!";
    }

    @Override
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
        return "你好，" + someBodyName + "!";
    }
}
