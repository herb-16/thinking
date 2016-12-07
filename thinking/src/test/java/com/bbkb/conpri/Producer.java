package com.bbkb.conpri;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/23<br>
 */
public class Producer implements Runnable {
    //    用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。volatile很容易被误用，用来进行原子性操作。
    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id=" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(SLEEPTIME);
                data = new PCData(count.incrementAndGet());//构造任务数据
                System.out.println(data + " is put into queue");
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    //提交数据到缓冲区
                    System.err.println("failed to put data:"+data);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
