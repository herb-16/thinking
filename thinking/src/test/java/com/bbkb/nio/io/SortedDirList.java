package com.bbkb.nio.io;

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
public class SortedDirList {
    private File file;

    public SortedDirList() {
        this.file = new File(".");
    }

    public SortedDirList(File file) {
        this.file = file;
    }

    public String[] list(){
        String[] files = file.list();
        return files;
    }
    public String[] list(final String regexp) {
        final Pattern pattern = Pattern.compile(regexp);
        String[] files = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        return files;

    }
}
