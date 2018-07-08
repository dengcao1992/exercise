package com.dcs.exercise;

import java.util.Scanner;

/*
数组压缩
n个升序数子
2个以上连续的变为x-y
 */
public class NumberReduce {
    public static int plat(int[] arr,int i){
        int r = 0;
        for (int j = i;j < arr.length;j++){
            if (j == arr.length-1){
                if (arr[j]==arr[j-1]+1){
                    return j;
                }
            }
            if (arr[j] != arr[j+1]-1){
                r = j;
                break;
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int begin = 0;
        int end = 0;
        int num = 0;
        for (int i = 0;i < n;i++){
            arr[i] = scanner.nextInt();
        }
        for (int i = 0;i < n;i++){
            if (i == n-1){
                System.out.print(arr[i]);
                continue;
            }
            if (arr[i] == arr[i+1] -1){
                int r = plat(arr,i);
                if (r - i >= 2){
                    begin = arr[i];
                    end = arr[r];
                    if (r == n-1){
                        System.out.print(begin+"-"+end);
                        break;
                    }
                    System.out.print(begin+"-"+end+",");
                    i = r;
                    continue;
                }
            }
            System.out.print(arr[i]+",");
        }

    }

}
