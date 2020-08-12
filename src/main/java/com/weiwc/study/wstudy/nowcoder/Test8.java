package com.weiwc.study.wstudy.nowcoder;

import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-02 16:13
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            int [] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }
            int type = scanner.nextInt();
            int [] result = quickSort(nums, 0, nums.length - 1 ,type);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int [] quickSort (int [] arr, int low, int high, int type) {
        int start = low;
        int end = high;
        int key = arr[low]; // 基准值
        while (end > start) {
            // 从后向前比
            while (end > start && (type == 0 ? arr[end] >= key : arr[end] <= key)) {
                end--;
            }
            if (type == 0 ? arr[end] <= key : arr[end] >= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            // 从前向后比
            while (end > start && (type == 0 ? arr[start] <= key : arr[start] >= key)) {
                start++;
            }
            if (type == 0 ? arr[start] >= key : arr[start] <= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        // 递归比较左、右分支
        if (start > low) {
            quickSort(arr, low, start - 1, type);
        }
        if (end < high) {
            quickSort(arr, end + 1, high, type);
        }
        return arr;
    }
}
