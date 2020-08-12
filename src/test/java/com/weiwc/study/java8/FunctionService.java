package com.weiwc.study.java8;

/**
 * @author weichen
 * @description: 函数式接口，注意：只包含一个抽象方法,或多个default修饰的默认方法
 * @create 2020-05-12 22:17
 */
@FunctionalInterface
public interface FunctionService {
    void test();

    default void printString(String msg) {
        System.out.println(msg);
    }
}
