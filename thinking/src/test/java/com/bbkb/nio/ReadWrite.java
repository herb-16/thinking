package com.bbkb.nio;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/21<br>
 */
public class ReadWrite {

    @Test
    public void testRead() {
        try {
//            1、读数据
//            读入Channel
            FileInputStream fileInputStream = new FileInputStream(new File("F:\\codingTest\\entityManager.txt"));
            FileChannel fileChannel = fileInputStream.getChannel();
//            读入buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer);
//            文件内容已在ByteBuffer中,可以关闭通道，读取ByteBuffer
            System.out.println("========================================");
            byteBuffer.flip();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder charsetDecoder = charset.newDecoder();
            System.out.println(charsetDecoder.decode(byteBuffer.asReadOnlyBuffer()).toString());
            System.out.println("========================================");
//            System.out.println(byteBuffer.asCharBuffer());
            fileChannel.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBuffer() {
//        创建buffer
//        方法一、从堆中分配缓冲区
//        ByteBuffer byteBuffer = ByteBuffer.allocate(15);

//        方法二、从一个既有数组中创建缓冲区
        byte array[] = new byte[1024];
        ByteBuffer byteBuffer = ByteBuffer.wrap(array);
        System.out.println("limit = " + byteBuffer.limit() + " capacity = "
                + byteBuffer.capacity() + " position = " + byteBuffer.position());
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        System.out.println("limit = " + byteBuffer.limit() + "capacity = "
                + byteBuffer.capacity() + " position = " + byteBuffer.position());
        byteBuffer.flip();//将position置为0，limit置为当前为置的position
        System.out.println("limit = " + byteBuffer.limit() + " capacity = "
                + byteBuffer.capacity() + " position = " + byteBuffer.position());
        System.out.println("上午");
        for (int i = 0; i < 5; i++) {
            System.out.println(byteBuffer.get());
        }
        System.out.println();
        System.out.println("limit = " + byteBuffer.limit() + " capacity = "
                + byteBuffer.capacity() + " position = " + byteBuffer.position());
        byteBuffer.flip();//读写转换
        System.out.println("limit = " + byteBuffer.limit() + " capacity = "
                + byteBuffer.capacity() + " position = " + byteBuffer.position());

        byteBuffer.rewind();//为提取byteBuffer的有效数据做准备
        byteBuffer.clear();//为重新写Buffer做准备
        byteBuffer.flip();//通常在读写转换时使用


    }

    @Test
    public void standardBuffer() {
//        byte array[] = new byte[10];
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print(byteBuffer.get());
            if (i == 4) {
                byteBuffer.mark();
                System.out.print("mark at " + byteBuffer.get(i));
            }
        }
        byteBuffer.reset();
        System.out.println("\nreset to mark");
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get());
        }
    }

    //    复制缓冲区
    @Test
    public void testDuplicate() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer byteBuffer1 = byteBuffer.duplicate();
        System.out.println("After byteBuffer.duplicate()");
        System.out.println("byteBuffer = " + byteBuffer);
        System.out.println("byteBuffer1 = " + byteBuffer1);
        byteBuffer1.flip();
        System.out.println("After byteBuffer1.flip()");
        System.out.println("byteBuffer = " + byteBuffer);
        System.out.println("byteBuffer1 = " + byteBuffer1);
        byteBuffer1.put((byte) 100);
        System.out.println("After byteBuffer.put((byte) 100)");
        System.out.println("byteBuffer = " + byteBuffer);
        System.out.println("byteBuffer1 = " + byteBuffer1);
    }

    //    缓冲区分片
    @Test
    public void testSlice() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.position(2);
        byteBuffer.limit(6);
        ByteBuffer subBuffer = byteBuffer.slice();
        for (int i = 0; i < subBuffer.capacity(); i++) {
            byte bb = subBuffer.get(i);
            bb *= 10;
            subBuffer.put(i, bb);
        }
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.print(byteBuffer.get() + ",");
        }
    }

    //    只读缓冲区
    @Test
    public void testReadOnlyBuffer() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer readOnly = byteBuffer.asReadOnlyBuffer();
        while (readOnly.hasRemaining()) {
            System.out.print(readOnly.get() + ",");
        }
        System.out.println();
        byteBuffer.put(2, (byte) 20);
//        readOnly.put(2,(byte)20);
        readOnly.flip();
        while (readOnly.hasRemaining()) {
            System.out.print(readOnly.get() + ",");
        }
        System.out.println();
    }

    //    文件映射到内存
    @Test
    public void testMap() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("F:\\codingTest\\entityManager.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, randomAccessFile.length());
            while (mappedByteBuffer.hasRemaining()) {
                System.out.print(mappedByteBuffer.get());
            }
            mappedByteBuffer.put(0, (byte) 100);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    处理结构化数据

    @Test
    public void testBook() {
        //聚集写操作
        try {
            ByteBuffer bookBuf = ByteBuffer.wrap("thinking in java".getBytes("utf-8"));
            ByteBuffer authorBuf = ByteBuffer.wrap(" haha".getBytes("utf-8"));
            int booklen = bookBuf.limit();
            int authotLen = authorBuf.limit();
            System.out.println(booklen + "," + authotLen);
            ByteBuffer[] buffers = new ByteBuffer[]{bookBuf, authorBuf};
            File file = new File("F:\\codingTest\\testBook.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                FileChannel fileChannel = fileOutputStream.getChannel();
                try {
                    fileChannel.write(buffers);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testBook2() {
        //散射读操作
//        error
        ByteBuffer bookBuf = ByteBuffer.allocate(16);
        ByteBuffer authorBuf = ByteBuffer.allocate(5);
        int booklen = bookBuf.limit();
        int authotLen = authorBuf.limit();
        ByteBuffer[] buffers = new ByteBuffer[]{bookBuf, authorBuf};
        File file = new File("F:\\codingTest\\testBook.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileChannel fileChannel = fileOutputStream.getChannel();
        try {
            fileChannel.read(buffers);
            String bookName = new String(buffers[0].array(), "utf-8");
            String authorName = new String(buffers[1].array(), "utf-8");
            System.out.println(bookName + "," + authorName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDirect() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                byteBuffer.putInt(j);
            }
            byteBuffer.flip();
            for (int j = 0; j < 99; j++) {
                byteBuffer.getInt(j);
            }
            byteBuffer.clear();
        }
        //位运算代替乘除法
//        a *= 2   <==>  a <<= 1;
//        a /= 2   <==>  a >>= 1;
    }


}
