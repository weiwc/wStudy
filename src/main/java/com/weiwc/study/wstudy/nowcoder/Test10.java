package com.weiwc.study.wstudy.nowcoder;

import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-03 23:00
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            int result = 0;
            for (int i = 0; i < num; i++) {
                long end = i * i;
                if (String.valueOf(end).endsWith(String.valueOf(i))) {
                    result ++;
                }
            }
            System.out.println(result);
//            int start = 1;
//            int flag = 0;
//            do {
//                int data = start * start;
//                char [] startString = String.valueOf(start).toCharArray();
//                char [] dataString = String.valueOf(data).toCharArray();
//                boolean state = true;
//                for (int i = 0; i < startString.length; i++) {
//                    char d = dataString[dataString.length - 1 - i];
//                    char s = startString[startString.length - 1 - i];
//                    if ( d != s){
//                        state = false;
//                    }
//                }
//                if (state) {
//                    flag++;
//                }
//                start++;
//            } while (start != num);
//            System.out.println(flag);
        }
    }
}
