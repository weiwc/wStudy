package com.weiwc.study.wstudy;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-04-08 10:03
 */
@Component
public class DailyTmperatures {
    Solution1 solution1;

    public DailyTmperatures() {
        solution1 = new Solution1();
    }

    class Solution1 {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                int temp = T[i];
                int count = 0;
                boolean flag = false;
                for (int j = i+1; j < T.length ; j++) {
                    count++;
                    if (temp < T[j]) {
                        result[i] = count;
                        flag = true;
                        break;
                    }
                }
                if (!flag) result[i] = 0;
            }
            return result;
        }
    }

    class solucation2 {
        // 栈 用来存储下标，注意 已知下标的话，必可知元素
        Stack<Integer> stack;
        // 结果集，用来存储隔离天数
        int [] postions;
        public int[] dailyTemperatures(int[] T) {
            stack = new Stack<>();
            postions = new int [T.length];
            // 遍历数组
            for (int i = 0; i < T.length; i++) {
                // 这里理论上将就是遍历栈，来检测是否还有元素小于当前元素的，及升温
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    // 隔离天数 为当前下表减去栈顶下表计算出来的
                    postions[stack.peek()] = i - stack.peek();
                    // 出栈
                    stack.pop();
                }
                // 如果遍历完栈，记得当前下表入栈
                stack.push(i);
            }
            return postions;
        }
    }
}
