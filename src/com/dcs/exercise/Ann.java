package com.dcs.exercise;

import java.util.Scanner;

/*
升序全排列
输入升序
输入 n
n行升序数字 1-9
 */
public class Ann {
    public static void arrwap(int[] arr,int[] a,int[] b,int nun,int end){
        if (nun == end){
            for (int i = 0;i < arr.length;i++){
                if (a[i] == 1){
                    continue;
                }
                b[nun] = arr[i];
                for (int j = 0;j < b.length;j++){
                    System.out.print(b[j]);
                }
                System.out.println();
            }
        }else {
            for (int i = 0;i < arr.length;i++){
                if (a[i] == 1){
                    continue;
                }
                a[i] = 1;
                b[nun] = arr[i];
                arrwap(arr,a,b,nun+1,end);
                a[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i =0;i < n;i++){
            arr[i] = scanner.nextInt();
        }
        arrwap(arr,a,b,0,n-1);


    }
}
