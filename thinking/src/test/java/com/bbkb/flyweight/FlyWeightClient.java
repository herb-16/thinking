package com.bbkb.flyweight;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class FlyWeightClient {

    /*
    * 享元模式
    * */
    public static void main(String[] args) {
        ReportManagerFactory rmf=new ReportManagerFactory();
        IReportManager rm=rmf.getFinancialReportManager("A");
        rm.createReport();
        IReportManager rm1 = rmf.getEmployeeReportManager("A");
        rm1.createReport();
    }
}
