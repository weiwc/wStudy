package com.weiwc.study.wstudy.nowcoder;

import java.io.CharArrayWriter;
import java.util.*;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-02 10:41
 */
public class Test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String data = scanner.nextLine();
            char[] dataList = data.toCharArray();
            // 这里需要先用TreeMap的比较器特性，先将map通过compareTo排序（通过ASCII码排序）
            // 原先用的HashMap无效。。。
            Map<Character, Integer> map = new TreeMap<>(Character::compareTo);
            for (char c : dataList) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) +1);
                } else {
                    map.put(c, 1);
                }
            }
            // 排序为先通过key进行ASCII码排序，再通过value排序
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            list.forEach(item -> {
                System.out.print(item.getKey());
            });
            // 这里必须手动换行。。。
            System.out.println();
        }
    }
}
