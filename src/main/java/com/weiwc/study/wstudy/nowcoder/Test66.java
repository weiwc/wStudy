package com.weiwc.study.wstudy.nowcoder;

import java.util.*;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-02 9:18
 */
public class Test66 {
    private static HashMap<String, String> map = new HashMap<>();
    private static Set<String []> set = new HashSet<>();
    static {
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        for (String s : map.keySet()) {
            String [] temp = s.split(" ");
            set.add(temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String [] data = scanner.nextLine().split(" ");
            String result = null;
            for (String[] strings : set) {
                if (strings[0].startsWith(data[0])) {
                    if (data.length == strings.length) {
                        if (data.length == 1) {
                            result = strings[0];
                        } else {
                            if (strings[1].startsWith(data[1])) {
                                result = strings[0] + " " + strings[1];
                            }
                        }
                    }
                }
            }
            if (result == null) {
                System.out.println("unknown command");
            } else {
                System.out.println(map.get(result));
            }
        }
    }
}
