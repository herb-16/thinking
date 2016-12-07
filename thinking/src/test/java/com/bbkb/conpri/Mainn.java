package com.bbkb.conpri;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 项目名称:car
 * 功能说明:
 * 系统版本:v1.0
 * JDK版本:JDK 1.7
 * 开发人员:sujj@bababus.com<br>
 * 开发时间:2016/11/23<br>
 */
public class Mainn {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingDeque<PCData>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
