package com.bbkb.observer.obser;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/5<br>
 */
public class NBAMate {
    private String name;
    private ISubject secretary;

    public NBAMate(String name) {
        this.name = name;
    }

    public NBAMate(String name, ISubject secretary) {
        this.name = name;
        this.secretary = secretary;
    }

    public void updateNBA(){
        System.out.println(name+" 关闭视频，去工作");
    }
}
