package com.weiwc.study.thread;

import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weichen
 * @description: ReentrantLock如何避免死锁：响应中断、可轮询锁、定时锁
 * 这个例子，线程lock1和lock2方法中返回thread，但是在thread线程中都请求了lock1和lock2的锁，且顺序不同
 * 这就有可能造成线程死锁
 * @create 2020-05-05 10:44
 */
@Component
public class InterruptiblyLock {
    // 定义锁1、锁2
    public ReentrantLock lock1 = new ReentrantLock();
    public ReentrantLock lock2 = new ReentrantLock();

    public Thread lock1() {
        Thread t = new Thread(() -> {
            try {
                // 如果当前线程未被中断，则获取锁
                lock1.lockInterruptibly();
                // 线程sleep
                Thread.sleep(500);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() +",执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // sleep后，如果当前线程仍然持有该锁，则释放锁
                if (lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() +",退出");
            }
        });
        t.start();
        return t;
    }

    public Thread lock2() {
        Thread t = new Thread(() -> {
            try {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() +",执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() +",退出");
            }
        });
        t.start();
        return t;
    }
}
