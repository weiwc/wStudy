package com.weiwc.study.wstudy.nowcoder;

import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-07-31 19:20
 */
public class test1 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        Integer b = scanner.nextInt();
        Integer max = getResult(a, b);
        Integer multiplier = a * b;
        System.out.println( max == 0 ? multiplier : multiplier / max);
    }

    private static Integer getResult(Integer a, Integer b) {
        if (a == null || b == null) {
            return -1;
        }
        Integer dValue = a - b;
        Integer num =  dValue > 0 ? dValue : dValue*-1;
        return num == 0 ? a : getResult(num, dValue > 0 ? b : a );
    }
}
