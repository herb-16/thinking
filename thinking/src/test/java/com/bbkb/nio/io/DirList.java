package com.bbkb.nio.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class DirList {
    public static void main(final String[] args){
//        查看目录列表\src\text\resources
        File file = new File(".\\car-deploy\\src\\test" +
                "\\resources");
        String[] list;
        if (args.length==0){
            list = file.list();
        }else {
//            list = file.list(filter(args[0]));
            list =  file.list(filter1(args));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        long length = 0;
//      打开文件
//       1
        for (String s:list){
            System.out.println(s);
        }



//        3
//        for (String s:list){
//            long fs  = new File(file,s).length();//文件尺寸的大小
//            System.out.println(s+" = "+fs);
//            length += fs;
//        }
//        System.out.println("===================");
//        System.out.println(length/1024+"kb");


    }

//    练习1
    public static FilenameFilter filter1(final String[] args){
        final String ext = args[0].toLowerCase();//将字符串转成小写
        FilenameFilter filter= new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.toLowerCase().endsWith(ext)){
                    if (args.length == 1){
                        return true;
                    }
                    Set<String> words = new HashSet<String>(new TextFile(new File(dir,name).getAbsolutePath(),"\\W+"));
                    for (int i=0;i<args.length;i++){
                        if (words.contains(args[i])){
                            return true;
                        }
                    }
                    return true;
                }
                return false;
            }
        };
        return filter;
    }



//    创建一个filter方法，返回FilterName的一个引用
    public static FilenameFilter filter(final String arg){
        final Pattern pattern = Pattern.compile(arg);
        FilenameFilter filter =  new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(arg).matches();
            }
        };
        return filter;
    }
}
