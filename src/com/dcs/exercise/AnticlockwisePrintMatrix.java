package com.dcs.exercise;
/*
逆时针打印矩阵
输入n行 m列
01 02 03....输入
 */

import java.util.Scanner;

public class AnticlockwisePrintMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count =0;
        int countMax = m*n;
        int[][] num = new int[n][m];
        for (int i = 0; i<n;i++){
            for (int j = 0;j<m;j++){
                num[i][j] = sc.nextInt();
            }
        }
        int c = 1,a= 0,b=0;

        for(int i =0;i<n;i++){

            System.out.print(num[a][b] + " ");
            count++;
            if(count == countMax){
                break;
            }
            a = a+c;
        }
        m--;
        n--;
        a--;
        while (true){
            for (int i = 0;i<m;i++){
                b = b+c;
                System.out.print(num[a][b] + " ");
                count++;
            }

            c = -c;
            m--;
            if(count == countMax){
                break;
            }
            for( int i = 0; i<n; i++){
                a = a+c;
                System.out.print(num[a][b] + " ");
                count++;

            }
            if(count == countMax){
                break;
            }
            n--;
        }

    }
}

