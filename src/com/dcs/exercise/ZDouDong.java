package com.dcs.exercise;
/*
z子抖动再按行输出
 */
public class ZDouDong {
    public static String con(String result,int i,int j,int begin,String s){
        if(begin >= s.length()){
            return result;
        }
        result = result + s.charAt(begin);
        while (begin < s.length()){
            begin = begin +i;
            if (begin >= s.length()) break;
            result = result + s.charAt(begin);
            begin = begin + j;
            if (begin >= s.length()) break;
            result = result + s.charAt(begin);
        }
        return result;
    }
    public static String convert(String s, int numRows) {
        String result = "";
        if (s.length() == 0){
            return result;
        }
        if (numRows == 1){
            return s;
        }
        int[] cha = new int[numRows];
        for (int i = 0; i < numRows -1;i++){
            cha[i] = 2*(numRows - 1) - i*2;
        }
        result = con(result,cha[0],cha[0],0,s);
        for (int i = 1;i < numRows - 1 ;i++){
            result = con(result,cha[i] ,cha[0] - cha[i] , i , s);
        }
        result = con(result,cha[0],cha[0],numRows -1,s);
        return result;
    }

    public static void main(String[] args) {
        String s = convert("abcdef",2);
        System.out.println(s);

    }
}
