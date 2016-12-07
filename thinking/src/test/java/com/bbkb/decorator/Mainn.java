package com.bbkb.decorator;

import java.io.InputStream;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class Mainn {
    public static void main(String[] args) {
        IPacketCreator pc=new PacketHTTPHeaderCreator(
                new PacketHTMLHeaderCreator(
                        new PacketBodyCreator()));
        System.out.println(pc.handleContent());
    }

    /*
    * inputStream和outputSteam 是应用了装饰者模式
    * 性能组件和功能组件的分离
    * */




}
