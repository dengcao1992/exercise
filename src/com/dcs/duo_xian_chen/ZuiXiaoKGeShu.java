package com.dcs.duo_xian_chen;

import java.util.ArrayList;
import java.util.Scanner;

public class ZuiXiaoKGeShu {
    public static void heapMin(int[] input ,int i , int heapSize){
        if (i < 0 || i > heapSize) return;
        int l = i *2 ;
        int r = i * 2 + 1;
        int min = input[i];
        int minI = i;
//        if ((l > heapSize || input[i] <= input[l]) && (r > heapSize || input[i] <= input[r])){
//            return;
//        }
        if (l <= heapSize && min > input[l]){
            min = input[l];
            minI = l;
        }
        if (r <= heapSize && min > input[r]){
            min = input[r];
            minI = r;
        }
        if (minI != i){
            input[minI] = input[i];
            input[i] = min;
            heapMin(input, minI, heapSize);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || k == 0) return res;
        if (input.length < k) return res;
        int heapSize = input.length - 1;
        int heapLeaf = (input.length >> 1) - 1;
        for (int i = heapLeaf;i >= 0;i--){
            heapMin(input,i,heapSize);
        }
        for (int i = 0; i < k;i++){
            res.add(input[0]);
            int a = input[0];
            input[0] = input[heapSize];
            input[heapSize] = a;
            heapSize--;
            heapMin(input,0,heapSize);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n;i++){
            input[i] = sc.nextInt();
        }
        ArrayList<Integer> res = new ArrayList<>();
        res = GetLeastNumbers_Solution(input,k);
        for (int i = 0;i < res.size();i++){
            if (i != res.size()-1) System.out.print(res.get(i) + ",");
            else System.out.println(res.get(i));
        }
    }



}
