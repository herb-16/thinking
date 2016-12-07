package com.bbkb.conpri;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/23<br>
 */
//生产者与消费者之间的共享数据
public final class PCData {
    private final int intData;

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "intData:" + intData;
    }
}
