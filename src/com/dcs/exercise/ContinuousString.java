package com.dcs.exercise;

import java.util.Scanner;
/*
最长连续子串
a b最长相同连续子串
 */

public class ContinuousString {
    public static int dp(int i,int j,String a,String b,int[][] p){
        int q = 0;
        if (p[i][j] != 0){
            return p[i][j] == -1 ? 0:p[i][j];
        }
        if (i == 0 || j == 0){
            p[i][j] = -1;
            return q;
        }
        int q1 = dp(i-1,j,a,b,p);
        int q2 = dp(i,j-1,a,b,p);
        if (q1 == q2){
            for (int g = 0;g <= q1;g++){
                if (a.charAt(i - 1 - g) != b.charAt(j - 1 - g)) {
                    return q = q1;
                }
            }
            return q = q1 + 1;
        }
        q = q1 > q2 ? q1 : q2;
        p[i][j] = q == 0 ? -1 : q;
        return q;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int[][] p = new int[a.length() + 1][b.length() + 1];
        int q = dp(a.length(),b.length(),a,b,p);
        System.out.println(q);

    }
}
