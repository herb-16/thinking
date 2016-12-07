package com.bbkb.nio.io;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class Demo1 {

    @Test
    public void HelloWorld() throws IOException {
        //判断是文件还是目录
//        String dirPath = "D:/HelloWorld.txt";
//        在d盘创建HelloWorld.txt
        File file = new File("D:/hi.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.isDirectory()){
            System.out.println(file.getName()+"是一个目录");
        }else if (file.isFile()){
            System.out.println(file.getName()+"是一个文件");
        }else {
            System.out.println("都不是");
        }
        System.out.println(file.getTotalSpace());
    }

    @Test
    public void IOTest(){
        String dirPath = "d:/IOTest";
        File file = new File(dirPath);
        if (file.isDirectory()){
            String[] list = file.list();
            for (int i=0;i<list.length;i++){
                System.out.println(list[i]);
            }
        }
    }


//    Demo3
//    递归实现列出当前工程下所有.Java文件
    @Test
    public void JAVATest(){
        File file = new File(".");
        String[] list;
//        final Pattern pattern = Pattern.compile("^wjava$");
//        list = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return true;
//            }
//        });

        list = getAllFiles(file).clone();
        int length = list.length;
        for (int i =0;i<length;i++){
            System.out.println(list[i]);
        }
    }

    private String[] getAllFiles(File file){
        if (file.isDirectory()){
            return file.list();
        }else if (file.isFile()){
            String[] strings = {file.toString()};
            return strings;
        }
        return null;
    }



    public static void main(String[] args){

    }

}
