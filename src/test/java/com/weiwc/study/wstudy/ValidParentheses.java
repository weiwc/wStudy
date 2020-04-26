package com.weiwc.study.wstudy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author weichen
 * @description: 有效的括号
 * @create 2020-04-07 14:08
 */
@Component
public class ValidParentheses {

    class Solution {
        HashMap<Character, Character> map = new HashMap<Character, Character>() {
            {
                put(']','[');
                put('}','{');
                put(')','(');
            }
        };
        public boolean isValid(String s){
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    char temp = stack.empty() ? '?' : stack.pop();
                    if (temp != map.get(c)) return false;
                } else {
                    stack.push(s.charAt(i));
                }
            }
            return stack.empty();
        }
    }
}
