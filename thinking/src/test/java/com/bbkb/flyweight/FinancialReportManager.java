package com.bbkb.flyweight;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class FinancialReportManager implements IReportManager {
    protected String tenantId = null;
    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public void createReport() {
        System.out.println("this is a financial report");
    }
}
