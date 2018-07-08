package com.dcs;

import java.util.Scanner;
/*
s=1
m=1

每次m=s s=s+s或者s=s+m
最少次数使s=n；
 */

public class Main {
    int s;
    int m;
    public Main(int s,int m){
        this.s = s;
        this.m = m;
    }
    Main lift = null;
    Main right = null;
    public int next(int con,int n){
        con++;
        int r = -1;
        if(s+s==n||s+m==n) return con;
        if (s+s>n && s+m>n) return r;
        lift = new Main(s+s,s);
        right = new Main(s+m,m);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main test6 = new Main(1,1);
        int result = test6.next(0,n);
        System.out.println(result);
    }
}
