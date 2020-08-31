package com.weiwc.study.wstudy.xingyeExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weichen
 * @description: 给定一个整数数组a，其中1<= a[i] <= n,其中有些元素出现两次而其他元素出现一次。找到所有出现两次的元素
 * @create 2020-08-25 11:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String in = scanner.nextLine();
            String[] split = in.split(",");
            HashMap<String, Integer> map = new HashMap<>(split.length);
            for (String s : split) {
                if (map.containsKey(s)){
                    int i = map.get(s);
                    map.replace(s, ++i);
                } else {
                    map.put(s, 1);
                }
            }
            StringBuilder out = new StringBuilder();
            for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
                if (stringIntegerEntry.getValue() == 2) {
                    out.append(stringIntegerEntry.getKey()).append(" ");
                }
            }
            System.out.println(out);
        }
    }
}
