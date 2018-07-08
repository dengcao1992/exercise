package com.dcs;

import java.util.Scanner;

public class Tiaoban {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = 0;
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int h = scanner.nextInt();
        int[] ban = new int[n];
        for (int i = 0;i < n;i++){
            ban[i] = scanner.nextInt();
        }
        for (int i = 0;i < n;i++){
            if (i == n-1){
                if (ban[i] <= begin + h){
                    begin = begin + (ban[i] - begin)*2;
                    h--;
                }
            }
            if (ban[i] <= begin + h && ban[i] > begin){
                begin = begin + (ban[i] - begin)*2;
                k--;
            }
            if (k == 0) break;
        }
        System.out.println(begin);
    }
}
