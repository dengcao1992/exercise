package com.dcs.exercise;

import java.util.Scanner;

public class SAddMToN {
    int s;
    int m;
    public SAddMToN(int s,int m){
        this.s = s;
        this.m = m;
    }
    SAddMToN lift = null;
    SAddMToN right = null;
    public int next(int con,int n){
        con++;
        int r = -1;
        if(s+s==n||s+m==n) return con;
        if (s+s>n && s+m>n) return r;
        lift = new SAddMToN(s+s,s);
        right = new SAddMToN(s+m,m);
        int r1 =lift.next(con,n);
        int r2 =right.next(con,n);
        if (r1!=-1) r = r1;
        if (r2!=-1) {
            if (r!=-1){
                r = r<r2 ? r:r2;
            }else {
                r = r2;
            }
        }
        return r;
    }

    public static void SAddMToN(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SAddMToN test6 = new SAddMToN(1,1);
        int result = test6.next(0,n);
        System.out.println(result);
    }
}
