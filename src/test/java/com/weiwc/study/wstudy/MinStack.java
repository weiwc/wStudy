package com.weiwc.study.wstudy;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-04-06 16:23
 */
@Component
public class MinStack{

    Stack<Integer> stack;
//    Stack<Integer> helper;
    Integer min;

    public MinStack() {
        stack = new Stack<>();
//        helper = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(Integer x) {
        // 当辅助栈为空或者入栈元素为最小元素入辅助栈
//        if (helper.isEmpty() || (x <= helper.peek())) {
//            helper.push(x);
//        }
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 当辅助栈非空 同时 stack的栈顶元素为最小元素
//        if (!helper.isEmpty() && (stack.peek() == helper.peek())) {
//            helper.pop();
//        }
        if (stack.pop() == min) {
            min = stack.pop();
        }
//        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
//        return helper.peek();
        return min;
    }
}
