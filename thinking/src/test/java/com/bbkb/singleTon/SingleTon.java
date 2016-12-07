package com.bbkb.singleTon;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/21<br>
 */
public class SingleTon implements Serializable{
    String name;

    private static SingleTon singleTon = new SingleTon();

    private SingleTon() {
        System.out.println("singleTon is create");
        name = "SerSingleton";
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    public static void createString(){
        System.out.println("createString is Singleton");
    }

    private Object readResolve(){
        return singleTon;
    }

    @Test
    public void test() throws IOException {
        SingleTon s1 = null;
        SingleTon s = SingleTon.getInstance();
        FileOutputStream fileOutputStream = new FileOutputStream("SingleTon.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(s);
        objectOutputStream.flush();
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("SingleTon.txt");
        ObjectInputStream objectInputStream =  new ObjectInputStream(fileInputStream);
//        s1 = (SingleTon)objectInputStream.readObject();
        Assert.assertEquals(s,s1);
    }
}
