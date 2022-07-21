package com.itcast.curator;

/**
 * @ClassName LockTest
 * @description: 分布式锁
 * @author: isquz
 * @time: 2022/5/25
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket12306 ticket12306 = new Ticket12306();

        Thread t1 = new Thread(ticket12306, "携程");
        Thread t2 = new Thread(ticket12306, "飞猪");
        Thread t3 = new Thread(ticket12306, "去哪儿");

        t1.start();
        t2.start();
        t3.start();



    }

}
