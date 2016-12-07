package com.bbkb.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/22<br>
 */
public class ReportManagerFactory {
    Map<String,IReportManager> finanicalReportManager = new HashMap<String, IReportManager>();
    Map<String,IReportManager> employeeReportManager = new HashMap<String, IReportManager>();
    public IReportManager getFinancialReportManager(String tenantId){
        IReportManager r=finanicalReportManager.get(tenantId);
        if(r==null){
            r=new FinancialReportManager(tenantId);
            finanicalReportManager.put(tenantId, r);
        }
        return r;
    }

    public IReportManager getEmployeeReportManager(String tenantId){
        IReportManager r=employeeReportManager.get(tenantId);
        if(r==null){
            r=new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, r);
        }
        return r;
    }



}
