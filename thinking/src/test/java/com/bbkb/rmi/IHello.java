package com.bbkb.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public interface IHello extends Remote{
    public String helloWorld() throws RemoteException;

    public String sayHelloToSomeBody(String someBodyName)throws RemoteException;
}
