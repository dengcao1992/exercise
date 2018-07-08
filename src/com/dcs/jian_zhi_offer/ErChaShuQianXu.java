package com.dcs.jian_zhi_offer;


import java.util.Stack;

public class ErChaShuQianXu {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode before = null;
        TreeNode res = null;
        while (true) {
            if (pRootOfTree.left != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
                continue;
            } else {
                if (before == null) {
                    before = pRootOfTree;
                    res = before;
                } else {
                    before.right = pRootOfTree;
                    pRootOfTree.left = before;
                    before = pRootOfTree;
                }
            }
            if (pRootOfTree.right != null) {
                pRootOfTree = pRootOfTree.right;
                continue;
            } else {
                if (!stack.empty()) pRootOfTree = stack.pop();
                else break;
                pRootOfTree.left = null;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ErChaShuQianXu test = new ErChaShuQianXu();
        ErChaShuQianXu.TreeNode s = test.new TreeNode(10);
        s.left = test.new TreeNode(6);
        s.right = test.new TreeNode(14);
        s.left.left = test.new TreeNode(4);
        s.left.right = test.new TreeNode(8);
        s.right.left = test.new TreeNode(12);
        s.right.right = test.new TreeNode(16);
        test.Convert(s);
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

