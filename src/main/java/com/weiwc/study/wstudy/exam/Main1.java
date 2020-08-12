package com.weiwc.study.wstudy.exam;

import java.util.*;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-05 21:31
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < size; j++) {
                datas.add(scanner.nextInt());
            }
        }
        datas.sort((a, b) -> b - a);
        List<Integer> result = new ArrayList<>(datas);
        while (result.size() > 1) {
            int temp = result.get(0) - result.get(1);
            if (temp == 0) {
                if (result.size() == 2) {
                    result = Collections.singletonList(0);
                } else {
                    List<Integer> integers = new ArrayList<>(result.subList(2, result.size()));
                    integers.sort((a, b) -> b - a);
                    result = integers;
                }
            } else {
                List<Integer> integers = new ArrayList<>(result.subList(2, result.size()));
                integers.add(temp);
                integers.sort((a, b) -> b - a);
                result = integers;
            }
        }
        System.out.println(result.get(0));
    }
}
