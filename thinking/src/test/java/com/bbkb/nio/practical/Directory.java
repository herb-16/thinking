package com.bbkb.nio.practical;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public final class Directory {
    public static File[] local(File dir,final String regexp){
        final Pattern pattern = Pattern.compile(regexp);
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path,final String regexp){
        return local(new File(path),regexp);
    }
}
