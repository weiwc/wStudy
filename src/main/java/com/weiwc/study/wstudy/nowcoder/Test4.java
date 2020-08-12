package com.weiwc.study.wstudy.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-07-31 22:13
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()){
            Integer num = scanner.nextInt();
            list.add(num);
        }
        if (list.size() == 0) {
            System.out.println(0);
        } else {
            Double a = list.stream().filter(item -> item > 0).map(Double::valueOf).collect(Collectors.averagingDouble(i->i));
            System.out.println((int) list.stream().filter(item -> item < 0).count());
            System.out.printf("%.1f",a);
        }
    }
}
