package com.weiwc.study.java8;

/**
 * @author weichen
 * @description: 创建Runnable接口的实现类，重写run方法，设置线程任务
 * @create 2020-04-24 14:39
 */
public class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "被创建了");
    }

    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread t = new Thread(runnable);
        t.start();

        // 简化代码，使用匿名内部类
        Runnable runnable1 = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "被创建了");
            }
        };
        new Thread(runnable1).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "被创建了");
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + "被创建了")).start();
    }
}
