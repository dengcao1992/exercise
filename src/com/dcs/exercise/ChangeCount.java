package com.dcs.exercise;

import java.util.Arrays;
import java.util.Scanner;
/*
交错和
 */
public class ChangeCount {
    public static long[][][] sum = new long[18][10][200];
    public static long[][][] sumNumber = new long[18][10][200];
    public static long[] tenPow = new long[18];
    public static long resultMax = 100000007;
    public static long seek(int length, int j,int k,boolean end,int[] number){
        long  result= 0;
        if(sum[length][j][k] <= resultMax  && !end){
            return sum[length][j][k];
        }
        if(j == 0){
            k = -k;
        }
        if(j - k < 0){
            k = k-200;
        }
        if(!end){ 
            for(int g = 9;g >= 0;g--){
                try {
                    result =result + seek(length-1, g,j-k,end,number) + tenPow[length]*j*seekNumber(length-1, g, j-k,end,number);

                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("length ="+length+" j ="+j+" k = "+k);
                    try {
                        Thread.sleep(100000000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            if (result > resultMax){
                result = result%resultMax;
            }
            if(k < 0){
                k = 200 + k;
            }
            sum[length][j][k] = result;
            return result;
        }
        if(length == 0){
            if(k < 0){
                k = 200 + k;
            }
            for(int g = number[0];g >= 0;g--){
                result =result + sum[0][g][k];
            }
            return result;
        }
        for(int g = number[length]-1;g >= 0;g--){
            result =result + seek(length-1, g,j-k,false,number) + tenPow[length]*j*seekNumber(length-1, g, j-k,false,number);
        }
        if(length == 1){
            for(int g = number[0];g >= 0;g--){
                result =result + seek(length-1, g,j-k,false,number)+10*j*seekNumber(length-1, number[length], j-k,true,number);
            }
            return result;
        }
        result = result + seek(length-1,number[length],j-k,true,number)+tenPow[length]*j*seekNumber(length-1, number[length], j-k,true,number);
        if (result > resultMax){
            result = result%resultMax;
        }
        return result;
    }
    public  static long seekNumber(int length, int j , int k,boolean end,int[] numbers){
        long number = 0;
        if (!end){
            if(sumNumber[length][j][k] <= resultMax ){
                return sumNumber[length][j][k];
            }
            for(int g = 9;g >= 0;g--){
                long a = seekNumber(length-1, g,j-k,end,numbers);
                if(a > 0){
                    number =number + a + 1;
                }
            }
            sumNumber[length][j][k] = number;
            return  number;
        }
        if(length == 0 && end){
            for (int m = 0; m <= numbers[0];m++){
                number =number+ sumNumber[0][m][k];
                return  number;
            }
        }
        for(int g = 0;g < numbers[length-1];g--){
            long a = seekNumber(length-1, g,j-k,false,numbers);
            if(a > 0){
                number =number + a + 1;
            }
        }
        number = number + seekNumber(length-1, numbers[length-1],j-k,true,numbers);

        return  number;
    }

    public static void main(String[] args){
        String min;
        String max;
        long sumMax = 0;
        long sumMin = 0;
        int k = 0;
        try (Scanner in = new Scanner(System.in)) {
            min  = in.next();
            max  = in.next();
            k = in.nextInt();
        }
        int[] r = new int[min.length()];
        int[] l = new int[max.length()];
        for(int i = min.length()-1;i >= 0;i--){
            r[i] = min.charAt(min.length()-i-1) - '0';
        }
        for(int i = max.length()-1;i >= 0;i--){
            l[i] = max.charAt(max.length()-i-1) - '0';
        }
        tenPow[0] = 1;
        for(int i = 1; i < tenPow.length; i++){
            tenPow[i] = 10*tenPow[i-1];
        }
        for(int i = 0; i < sum.length; i++){
            for(int j = 0; j <sum[0].length; j++){
                for (int g = 0; g < sum[0][0].length; g++){
                    if (i == 0 ){
                        if (j == g){
                            sum[i][j][g] = g;
                            sumNumber[i][j][g] = 1;
                        }else {
                            sum[i][j][g] = 0;
                            sumNumber[i][j][g] = 0;
                        }
                    }else {
                        sum[i][j][g] = resultMax+1;
                        sumNumber[i][j][g] = resultMax+1;
                    }
                }
            }
        }
        for(int i = 0;i < r[r.length-1]; i++){
//            if(i == 0){
//                sumMin = sumMin + seek(r.length-1, i , -k, false ,r);
//                continue;
//            }
            sumMin = sumMin + seek(r.length-1, i , k, false ,r);
        }
        sumMin = sumMin +seek(r.length-1,r[r.length-1],k ,true,r);
        for(int i = 0;i < l[l.length-1]; i++){
//            if(i == 0){
//                sumMax = sumMax + seek(l.length-1, i , -k, false ,l);
//                continue;
//            }
            sumMax = sumMax + seek(l.length-1, i , k, false ,l);
        }
        sumMax = sumMax +seek(l.length-1,l[l.length-1],k ,true,l);

        System.out.println(sumMax - sumMin);
        
        




    }

}
