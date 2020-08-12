package com.weiwc.study.wstudy.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-05 20:41
 */
public class Main0 {
    private static String [] chars = new String[26];
    static {
        chars[0] = "a";chars[1] = "b";chars[2] = "c";chars[3] = "d";chars[4] = "e";chars[5] = "f";
        chars[6] = "g";chars[7] = "h";chars[8] = "i";chars[9] = "j";chars[10] = "k";chars[11] = "l";
        chars[12] = "m";chars[13] = "n";chars[14] = "o";chars[15] = "p";chars[16] = "q";chars[17] = "r";
        chars[18] = "s";chars[19] = "t";chars[20] = "u";chars[21] = "v";chars[22] = "w";chars[23] = "x";
        chars[24] = "y";chars[25] = "z";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < num; i++) {
                String data = scanner.next();
                System.out.println(pass(data));
            }
        }
    }

    private static String pass(String data) {
        long [] insert = new long[data.length()];
        StringBuilder result = new StringBuilder();
        if (data.length() == 1){
            insert[0] = 1;
        }
        if (data.length() == 2) {
            insert[0] = 1;
            insert[1] = 2;
        }
        if (data.length() == 3) {
            insert[0] = 1;
            insert[1] = 2;
            insert[2] = 4;
        }
        if (data.length() > 3) {
            insert[0] = 1;
            insert[1] = 2;
            insert[2] = 4;
            for (int i = 3; i < data.length(); i++) {
                insert[i] = insert[i-1] + insert[i-2] + insert[i-3];
            }
        }
        char [] list = data.toCharArray();
        for (int i = 0; i < list.length; i++) {
            char temp = list[i];
            for (int j = 0; j < chars.length; j++) {
                if (temp == chars[j].charAt(0)) {
                    int n = (int) ((insert[i] + j) % chars.length);
                    list[i] = chars[n].charAt(0);
                }
            }
        }
        for (char c : list) {
            result.append(c);
        }
        return result.toString();
    }
}
