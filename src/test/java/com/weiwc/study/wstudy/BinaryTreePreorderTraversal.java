package com.weiwc.study.wstudy;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-04-22 9:49
 */
@Component
public class BinaryTreePreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (Objects.isNull(root)) {
                return result;
            }
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                result.add(node.val);
                if (node.left != null) {
//                if (!Objects.isNull(node.left)) {
                    stack.add(node.left);
                }
                if (node.right != null) {
//                if (!Objects.isNull(node.right)) {
                    stack.add(node.right);
                }
            }
            return result;
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            // java 集合 List set queue map
            // List 有三个实现类
            // ArrayList 数组实现 增删慢，查询快，线程不安全
            // Vector 数组实现 增删慢,查询快，线程安全
            // LinkedList 链表实现 增删快，查询慢，线程不安全
            LinkedList<Integer> result = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            if (Objects.isNull(root)) {
                return result;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                // 返回链表的尾结点
                TreeNode node = stack.pollLast();
                result.add(node.val);
                if (node.left != null) {
//                if (!Objects.isNull(node.left)) {
                    stack.add(node.left);
                }
                if (node.right != null) {
//                if (!Objects.isNull(node.right)) {
                    stack.add(node.right);
                }
            }
            return result;
        }
    }
}
