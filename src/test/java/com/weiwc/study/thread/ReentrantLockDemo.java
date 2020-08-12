package com.weiwc.study.thread;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weichen
 * @description: ReentrantLock 继承Lock接口并实现了再接口中定义的方法，是一个可重用锁
 * ReentrantLock通过自定义队列同步器（AQS）来实现锁的获取与释放。
 * @create 2020-05-04 11:21
 */
@Component
public class ReentrantLockDemo implements Runnable{
    // step 1: 定义一个ReentrantLock
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j<10; j++) {
            // step 2: 加锁
            lock.lock();
            // 可以重复加锁
            lock.lock();
            try {
                i++;
            } finally {
                // 释放锁
                // 注意，ReentrantLock是可重入锁，所以加了几次锁就必须释放几次锁
                lock.unlock();
                lock.unlock();
            }
        }
    }
}
