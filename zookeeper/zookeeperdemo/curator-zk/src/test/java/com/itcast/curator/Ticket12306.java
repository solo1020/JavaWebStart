package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Ticket12306
 * @description:
 * @author: isquz
 * @time: 2022/5/25
 */
public class Ticket12306 implements Runnable{

    private int tickers = 10;//数据库的票总数

    private InterProcessMutex lock;

    public Ticket12306(){
        String url = "127.0.0.1:2181";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);

        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(url)
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy).build();

        client.start();
        lock = new InterProcessMutex(client, "/lock");
    }

    @Override
    public void run() {
        while (true){
            // 获取锁
            try {
                lock.acquire(3, TimeUnit.SECONDS);

                if(tickers > 0){
                    System.out.println(Thread.currentThread().getName() + ": " + tickers);
                    tickers--;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                try {
                    lock.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
