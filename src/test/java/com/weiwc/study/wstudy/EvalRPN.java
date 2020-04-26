package com.weiwc.study.wstudy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-04-12 18:39
 */
@Component
public class EvalRPN {
    Solution solution;
    public EvalRPN() {
        solution = new Solution();
    }

    class Solution {
        HashMap<String , Integer> map = new HashMap() {
            {
                put("+", 1);
                put("-", 2);
                put("*", 3);
                put("/", 4);
            }
        };
        Stack<Integer> stack;
        public int evalRPN(String[] tokens) {
            stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (!stack.isEmpty() && map.containsKey(tokens[i])) {
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    switch (map.get(tokens[i])) {
                        case 1:
                            result = second + first;
                            stack.push(result);
                            break;
                        case 2:
                            result = second - first;
                            stack.push(result);
                            break;
                        case 3:
                            result = second * first;
                            stack.push(result);
                            break;
                        case 4:
                            result = second / first;
                            stack.push(result);
                            break;
                        default:
                            break;
                    }
                } else {
                    stack.push(Integer.valueOf(tokens[i]));
                }
            }
            return stack.pop();
        }
    }
}
