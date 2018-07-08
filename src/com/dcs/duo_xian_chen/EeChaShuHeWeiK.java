package com.dcs.duo_xian_chen;
/*
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class EeChaShuHeWeiK {
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        int sum = 0;
        ArrayList<Integer> oneRes = new ArrayList<>();
        Stack<TreeNode> beforeFound = new Stack<>();
        TreeNode treeNode = root;
        while (!(treeNode.left == null && treeNode.right == null && beforeFound.empty())){
            sum += treeNode.val;
            oneRes.add(treeNode.val);
            if (treeNode.left == null && treeNode.right == null){
                if (sum == target){
                    res.add(new ArrayList<Integer>(oneRes));
                }
                while (treeNode.right == null) {
                    treeNode = beforeFound.pop();
                    sum -= oneRes.get(oneRes.size() - 1);
                    oneRes.remove(oneRes.size() - 1);
                }
                treeNode = treeNode.right;
                continue;
            }
            if (treeNode.left == null){
                treeNode = treeNode.right;
            }else {
                beforeFound.push(treeNode);
                treeNode = treeNode.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        EeChaShuHeWeiK a = new EeChaShuHeWeiK();
        EeChaShuHeWeiK.TreeNode s =  a.new TreeNode(10);
        s.left=a.new TreeNode(5);
        s.left.left = a.new TreeNode(7);
        s.right = a.new TreeNode(12);
        s.left.right = a.new TreeNode(4);
        System.out.println(a.FindPath(s,22).toString());
    }

        public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
