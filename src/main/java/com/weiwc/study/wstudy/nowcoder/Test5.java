package com.weiwc.study.wstudy.nowcoder;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO 字符串分割
 * @create 2020-08-01 18:31
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                String temp = scanner.next();
                while ((temp.length() % 8) != 0) {
                    temp += "0";
                }
                for (int j = 0; j < temp.length(); j += 8) {
                    System.out.println(temp.substring(j, j+8));
                }
            }
        }
    }
}
