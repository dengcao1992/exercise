package com.dcs.exercise;


import java.util.Scanner;
/*
         交错和
 */
public class ChangeCount002 {
    public  long[][][] sum = new long[18][10][200];
    public  long[][][] sumNumber = new long[18][10][200];
    public  long[] tenPow = new long[18];
    public  long resultMax = 100000007;
    int[] r = null;
    int[] l = null;
    public  ChangeCount002 (String min,String max){
        int[] r = new int[min.length()];
        int[] l = new int[max.length()];
        for(int i = min.length()-1;i >= 0;i--){
            r[i] = min.charAt(min.length()-i-1) - '0';
        }
        for(int i = max.length()-1;i >= 0;i--){
            l[i] = max.charAt(max.length()-i-1) - '0';
        }
        this.r = r;
        this.l = l;
        tenPow[0] = 1;
        for(int i = 1; i < tenPow.length; i++){
            tenPow[i] = 10*tenPow[i-1];
        }
        for(int i = 0; i < sum.length; i++){
            for(int j = 0; j <sum[0].length; j++){
                for (int k = 0; k < sum[0][0].length; k++){
                    if (i == 0 ){
                        if (j == k - 100){
                            sum[i][j][k] = j;
                            sumNumber[i][j][k] = 1;
                        }else {
                            sum[i][j][k] = 0;
                            sumNumber[i][j][k] = 0;
                        }
                    }else {
                        sum[i][j][k] = resultMax+1;
                        sumNumber[i][j][k] = resultMax+1;
                    }
                }
            }
        }
    }
    public  long seek(int i, int j,int k,boolean isEnd,boolean isFirst0,int[] number){
        long  result= 0;
        if(sum[i][j][k+100] <= resultMax  && !isEnd){
            return sum[i][j][k+100];
        }
        if(!isEnd) {
            if (isFirst0){
                for (int g = 9; g > 0; g--){
                    result =result + seek(i-1, g,k-j,isEnd,false,number) + tenPow[i]*j*seekNumber(i-1, g, k-j,isEnd, false ,number);
                }
//                System.out.println(result);
                result =result + seek(i-1, 0,k-j,isEnd,true,number) + tenPow[i]*j*seekNumber(i-1, 0, k-j,isEnd,true ,number);
//                System.out.println(result);
//                System.out.println("...........................");

            }else {
                for (int g = 9; g >= 0; g--) {
                    result =result + seek(i-1, g,j-k,isEnd,isFirst0,number) + tenPow[i]*j*seekNumber(i-1, g, j-k,isEnd,isFirst0 ,number);
                }   
            }
            if (result > resultMax){
                result = result%resultMax;
            }
            sum[i][j][k+100] = result;
        }else {
            if (i == 0){
                return sum[i][j][k+100];
            }
            if (isFirst0){
                for(int g = number[i-1]-1;g > 0;g--){
                    result =result + seek(i-1, g,k-j,false,isFirst0,number) + tenPow[i]*j*seekNumber(i-1, g, k-j,false,isFirst0 ,number);
                }
                result =result + seek(i-1, 0,j-k,false,true,number) + tenPow[i]*j*seekNumber(i-1, 0, j-k,false,true ,number);
                result = result + seek(i-1,number[i-1],k-j,true,false,number)+tenPow[i]*j*seekNumber(i-1, number[i], k-j,true,false ,number);
            }else {
                for(int g = number[i-1]-1;g >= 0;g--){
                    result =result + seek(i-1, g,j-k,false,isFirst0,number) + tenPow[i]*j*seekNumber(i-1, g, j-k,false,isFirst0 ,number);
                }
                result = result + seek(i-1,number[i-1],j-k,true,isFirst0,number);
                System.out.println(result);
                System.out.println("................................");
                result = result + tenPow[i]*j*seekNumber(i-1, number[i-1], j-k,true,isFirst0 ,number);
                System.out.println(seekNumber(i-1, number[i-1], j-k,true,isFirst0 ,number));
                System.out.println("000000000000000000000000000000000000");
            }

        }
        if (result > resultMax){
            result = result%resultMax;
        }
        return  result;
    }
    public long seekNumber(int i, int j , int k,boolean end,boolean isFirst0 ,int[] number){
        long result = 0;
        if (!end ){
//            System.out.println(i);
//            System.out.println(j);
//            System.out.println(k);
            if(sumNumber[i][j][k+100] <= resultMax ){
                if(isFirst0 && i == 0){
                    return  0;
                }
                return sumNumber[i][j][k+100];
            }
            if (isFirst0){
                for(int g = 9;g > 0;g--){
                    long a = seekNumber(i-1, g,j-k,end,false ,number);
                    if(a > 0){
                        result =result + a + 1;
                    }
                }
                long a = seekNumber(i-1, 0,k-j,end,true ,number);
                if(a > 0){
                    result =result + a + 1;
                }
            }else {
                for(int g = 9;g >= 0;g--){
                    long a = seekNumber(i-1, g,j-k,end,isFirst0 ,number);
                    if(a > 0){
                        result =result + a + 1;
                    }
                }
                sumNumber[i][j][k+100] = result;
                return  result;
            }
        }else {
            if(i == 0 && end){
                for (int m = 0; m <= number[0];m++){
                    result =result+ sumNumber[0][m][k+100];
                    return  result;
                }
            }
            if (isFirst0){
                for(int g = 1;g < number[i-1];g++){
                    long a = seekNumber(i-1, g,j-k,end,false ,number);
                    if(a >0){
                        result =result + a + 1;
                    }
                }
                long a = seekNumber(i-1, 0,k-j,end,true ,number);
                if(a > 0){
                    result =result + a + 1;
                }
                result = result + seekNumber(i-1, number[i-1],j-k,true,isFirst0 ,number);
            }else {
                for(int g = 0;g < number[i-1];g++){
                    long a = seekNumber(i-1, g,j-k,false,isFirst0 ,number);
                    if(a > 0){
                        result =result + a + 1;
                    }
                }
                result = result + seekNumber(i-1, number[i-1],j-k,true,isFirst0 ,number);
            }
//            System.out.println("................................");
//            System.out.println(i);
//            System.out.println(j);
//            System.out.println(k);

        }

        return  result;
    }
    public long seekOne (int[] in,int k){
        long result = 0;
        if (in.length == 1){
            for(int i = 0;i <= in[in.length-1]; i++){
                result = result + sum[0][i][k+100];
            }
        }else{
            for(int i = 1;i < in[in.length-1]; i++){
                result = result + seek(in.length-1,i,k,false,false,in );
            }
//            System.out.println(result);
            result = result + seek(in.length-1, 0,k, false,true,in);
//            System.out.println(result);
            result = result+seek(in.length-1, in[in.length-1],k, true,false,in);
//            System.out.println(result);
        }
        if (result >= resultMax){
            result = result%resultMax;
        }
        return result;
    }

    public static void main(String[] args) {
        String min;
        String max;
        int k = 0;
        try (Scanner in = new Scanner(System.in)) {
            min  = in.next();
            max  = in.next();
            k = in.nextInt();
        }
        ChangeCount002 cc = new ChangeCount002(min,max);
        long result1 = cc.seekOne(cc.l,k);
        long result2 = cc.seekOne(cc.r,k);
        System.out.println(result1);
//        System.out.println(result2);



    }

}
