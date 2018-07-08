package com.dcs.exercise;

import java.util.Scanner;
/*
分数求和然后约分
 */
public class ScoreSum {
    static long fz ;
    static long fm ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] q = new int[n];
        for(int i = 0;i<n;i++){
            p[i] = sc.nextInt();
            q[i] = sc.nextInt();

        }


        if(n == 1){
            fz = p[0];
            fm  = q[0];
            func();
            System.out.println(fz + " " + fm);

        }else if(n == 2){
            fz = p[0]*q[1] + p[1]*q[0];
            fm = q[0]*q[1];
            func();
            System.out.println(fz + " " + fm);
        }else {
            fz = (long)(p[0]*q[1]*q[2]) + (long)(p[1]*q[0]*q[2])+ (long) (p[2]*q[1]*q[0]);
            fm = q[0]*q[1]*q[2];
            func();
            System.out.println(fz + " " + fm);
        }
    }
    private static  void  func(){
        long x = fz>fm?fm:fz;

        for (long i = 2;i<=x;i++){

            if (fz%i == 0 && fm%i == 0){
                fz = fz/i;
                fm = fm/i;
                i = 1;
            }
            x = fz>fm?fm:fz;
        }
    }
}
