package com.bbkb.conpri;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/23<br>
 */
public class Consumer implements Runnable {
    private BlockingQueue<PCData> qeque;

    private static final int SLEEPTIME = 100;

    public Consumer(BlockingQueue<PCData> deque) {
        this.qeque = deque;
    }

    @Override
    public void run() {
//        Thread 线程 是程序中的执行线程。Java 虚拟机允许应用程序并发地运行多个执行线程。
        System.out.println("start consumer id=" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCData data = qeque.take();
                if (null != data) {
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(),
                            re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();//中断线程
        }
    }
}
