package com.weiwc.study.wstudy.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-05 22:39
 */
public class Main2 {

    /**
     *
     * @param input int整型二维数组 按照考试排名进行编号的师徒分组
     * @return int整型一维数组
     */
    public static List<Integer> exam(int[][] input) {
        // write code here
        List<Integer> result =new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] ints : input) {
            for (int anInt : ints) {
                if (!map.containsKey(anInt)) {
                    map.put(anInt, 0);
                }
            }
        }
        for (int[] ints : input) {
            if ( ints[0] > ints[1]) {
                map.replace(ints[0], 1);
            }
        }
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            result.add(m.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        String step1 = in.replaceAll("\\[" ,"");
        String step2 = step1.replaceAll("]","");
        List<Integer> data = Arrays.stream(step2.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        int [] [] datas = new int[data.size()/2][2];
        for (int i = 0; i < data.size() / 2; i++) {
            for (int j = 0; j < 2; j++) {
                datas[i][j] = data.get(i+j);
            }
        }
        System.out.println(exam(datas));
    }
}
