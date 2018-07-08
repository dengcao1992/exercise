package com.dcs;


import java.util.Scanner;

public class Test2 {
    public static int nk(int n,int k){
        int res = 1;
        int max = 772235;
        for (int i = 0;i < n;i ++){
            res = res*k;
            if (res > max) res = res%max;
        }
        return res;
    }
    public static int cxy(int x,int y){
        int[][] ints = new int[x][y];
        int res = 1;
        int z = 0;
        if (x == y)  z = 1;
        else z = x-y;
        for (int i = 0;i < x;i++){
            res *= x-i;
        }
        for (int i = 0; i < y;i++){
            res /= y-i;
        }
        for (int i = 0; i < z;i++){
            res /= z-i;
        }
        return res;
    }
    public static int xx(int n,int k,int nk){
        int res = nk;
        int max = 772235;
            if (k == 1){
                res = 1;
                return res;
            }
            for (int i = 1; i < k;i++){
                int x = cxy(k,i) * xx( n, k-i,nk(n,k-i));
                res = res - x;
                if (res > max) res = res%max;
            }
//            res = res - cxy(k,k-1) * xx( n, k-1,res);
            return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ints= new int[k];
        int max = 772235;
        int res = 1;
        for (int i = 0;i < n;i ++){
            res = res*k;
            if (res > max) res = res%max;
        }


    }

}

