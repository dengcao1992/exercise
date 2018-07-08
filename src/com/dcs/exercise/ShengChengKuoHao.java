package com.dcs.exercise;

import java.util.ArrayList;
import java.util.List;

/*
给 n 对括号，写一个函数生成所有合适的括号组合。
 */
public class ShengChengKuoHao {
    public static List<String> result = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        result.clear();
        int left = n;
        int right = n;
        if (n == 0) return result;
        addlift("",left,right);
        return result;
    }
    public static void addlift(String s,int left,int right){
        if (right == 0 && left == 0){
            result.add(s);
        }
       for (int i = 1;i <= left;i++){
            s = s + "(";
            addright(s,left - i,right);
       }
    }
    public static void addright (String s,int left,int right){
        if (right == 0 && left == 0){
            result.add(s);
        }
        for (int i = 1;i <= right - left;i++){
            s = s + ")";
            addlift(s,left,right - i);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1).toString());
    }
}
