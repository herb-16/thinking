package com.bbkb.nio.practical;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/12/6<br>
 */
public class TreeInfo implements Iterable<File>{

    public List<File> files = new ArrayList<File>();
    public List<File> dirs = new ArrayList<File>();
    @Override
    public Iterator<File> iterator() {
        return files.iterator();
    }

    public void addAll(TreeInfo treeInfo){
        files.addAll(treeInfo.files);
        dirs.addAll(treeInfo.dirs);
    }

    @Override
    public String toString() {
        return "TreeInfo{" +
                "files=" + PPrint.format(files) +
                ", dirs=" + PPrint.format(dirs) +
                '}';
    }

    public static TreeInfo walk(String start,String regexp){
        return recurseDirs(new File(start),regexp);
    }

    public static TreeInfo walk(File start,String regexp){
        return recurseDirs(start, regexp);
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }


    static TreeInfo recurseDirs(File startDir,String regexp){
        TreeInfo result = new TreeInfo();
        for (File item :
                startDir.listFiles()) {
            if (item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regexp));
            }else {
                if (item.getName().matches(regexp)){
                    result.files.add(item);
                }
            }
        }
        return result;
    }

   public static void main(String[] args){
       if (args.length==0){
//           TreeInfo treeInfo = walk(".",".*\\.java");
           TreeInfo treeInfo = walk(".\\car-deploy");
           System.out.println(treeInfo);
//           for (File file:treeInfo.files){
//               System.out.println(file.getName());
//           }
           System.out.println("java文件的个数:"+treeInfo.files.size());
       } else {
           for (String arg : args) {
               System.out.println(walk(arg));
           }
       }
   }
}
