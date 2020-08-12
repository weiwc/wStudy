package com.weiwc.study.wstudy.nowcoder;

import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-01 20:59
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            int[] n = new int[size];
            for (int i = 0; i < size; i++) {
                n[i] = scanner.nextInt();
            }
            System.out.println(getMaxSteps(n, size));
        }
    }

    private static int getMaxSteps(int [] a, int size){
        // 动态规划数组，用来记录每个起点对应的最长递增子序列
        int[] dp = new int[size];
        int max = 1;
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            // 迭代搜索之前比自己小的元素中的dp[i](最长递增子序列)
            for (int j = 0; j < i; j++) {
                // 如果a[i]当前元素>a[j]前列的元素
                if (a[i] > a[j]) {
                    // 将前列dp+1与已记录的当前dp比较取最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 取出dp数组中的最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
