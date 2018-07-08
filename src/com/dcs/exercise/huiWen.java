package com.dcs.exercise;
/*
回文数
如aba
 */
public class huiWen {
    public static boolean back(String s,int i ,int j){
        boolean b = false;
        if (s.charAt(i) == s.charAt(j)){
            if (j - i ==1) return true;
            if (i+1 == j-1) return true;
            b = back(s,i+1,j-1);
        }
        return b;
    }
    public static String longestPalindrome(String s) {
        String result =""+s.charAt(0) ;
        for (int i = 0;i < s.length();i++){
            if (result.length() >= s.length() - i) return result;
            for (int j = s.length()-1;j > i;j--){
                if (result.length() >= j + 1 - i) break;
                if (s.charAt(i) == s.charAt(j)){
                    boolean b =back(s,i,j);
                    if (b){
                        String a =s.substring(i,j+1);
                        result = a.length() > result.length() ? a : result;
                        if (result.length() >= s.length() - i) return result;
                        break;
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String a =longestPalindrome("aaaaa");
//        String a = ""+"a";
        System.out.println(a);
    }
}
