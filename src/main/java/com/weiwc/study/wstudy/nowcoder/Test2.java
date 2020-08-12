package com.weiwc.study.wstudy.nowcoder;

import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-07-31 21:36
 */
public class Test2 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextFloat();
        System.out.printf("%.1f\n",getCubeRoot(input));
    }

    public static double getCubeRoot(double input) {
        double max = input;
        double mid = 0;
        double min = 0;
        while((max - min) > 0.00001) {
            mid = (max + min)/2;
            if ((mid * mid * mid) > input) {
                max = mid;
            } else if ((mid * mid * mid) < input) {
                min = mid;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
