package com.dcs.exercise;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class QingWaTiaoTaiJie {
    public static int JumpFloorII(int target) {
        if (target == 0) return 0;
        int result = 0;
        int[] jum = new int[target + 1];
        for (int i = 1;i < target + 1;i++){
            jum[i] = 1;
            for (int j = 1; j < i;j++){
                jum[i] +=  jum[i-j];
            }
        }
        result = jum[target];
        return result;
    }
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }
}
