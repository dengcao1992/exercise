package com.dcs.duo_xian_chen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ZiFuChuanPaiLie {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) return result;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        add(result,new StringBuilder().append(chars),0,new StringBuilder());
        Collections.sort(result);
        return result;
    }
    public static void add(ArrayList result,StringBuilder sb,int count,StringBuilder res){
        char before = '0';
        for (int i = 0;i < sb.length();i++){
            char ch = sb.charAt(i);
            if (ch == '0') continue;
            if (ch == before) continue;
            before = ch;
            sb.setCharAt(i,'0');
            StringBuilder oneRes = new StringBuilder(res);
            oneRes.append(ch);
            if (count < sb.length() - 1)add(result,sb,count+1,oneRes);
            else result.add(oneRes.toString());
            sb.setCharAt(i,ch);
        }
    }
    public static void main(String[] args) {
        System.out.println(Permutation("abc").toString());
    }



}

