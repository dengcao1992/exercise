package com.dcs.exercise;

import java.util.Scanner;
/*
打折
n 价格数
x 打折线
n个价格
输出能打折最低价格
 */

public class Discount {
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        num = new int[n];
        int sum = 0;
        for (int i =0;i<n;i++){
            num[i] = sc.nextInt();
            sum += num[i];
        }
        int res =-1;

        if(sum>=x){
            for (int i = x; ;i++){
                if (qy2(i) != 0) {
                    res =i;
                    break;
                }
            }
        }

        System.out.println(res);

    }
    public static int qy2 (int target){
        int[][] q = new int[num.length][target+1];
        for (int i = 0;i <= target;i++){
            q[num.length-1][i] = num[num.length-1]  == i || i == 0 ? 1:0;
        }
        for (int i = q.length-2; i >= 0;i--){
            for (int j = 0;j < q[0].length;j++){
                q[i][j] = j - num[i] >= 0 ? q[i+1][j] + q[i+1][j - num[i]] : q[i+1][j];
//                System.out.println(q[i][j]);
        }

        }
        return q[0][target];
        }
        }
