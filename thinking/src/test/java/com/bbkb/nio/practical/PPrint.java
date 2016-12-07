package com.bbkb.nio.practical;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class PPrint {
    public static String format(Collection<?> c){
        if (c.size()==0){
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Object o:c){
            if (c.size()!= 1){
                stringBuilder.append(" \n  ");
            }
            stringBuilder.append(o);
        }
        if (c.size() != 1){
            stringBuilder.append(" \n  ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void pprint(Collection<?> c){
        System.out.println(format(c));
    }

    public static void pprint(Object[] objects){
        System.out.println(format(Arrays.asList(objects)));
    }

}
