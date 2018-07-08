package com.dcs.jian_zhi_offer;


/*
有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。

给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 */
public class JieDianGongGongZuXian {
    public static int getLCA(int a, int b) {
        if (a < 1 || b < 1) return 0;
        int less = a < b ? a : b;
        int big = a > b ? a : b;
        if (less == big) return less;
        while (true){
            big = big >> 1;
            if (less == big) return less;
            less = less < big ? less : big;
            big = less > big ? less : big;
        }
    }

    public static void main(String[] args) {
       int s = getLCA(9,8);
        System.out.println(s);
    }
}
