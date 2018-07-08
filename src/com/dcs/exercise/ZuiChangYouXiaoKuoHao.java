package com.dcs.exercise;

import java.util.ArrayList;
import java.util.List;

/*
给一个只包含 '(' 和 ')' 的字符串，找出最长的有效（正确关闭）括号子串的长度。

对于 "(()"，最长有效括号子串为 "()" ，它的长度是 2。

另一个例子 ")()())"，最长有效括号子串为 "()()"，它的长度是 4。
 */
public class ZuiChangYouXiaoKuoHao {
    public static int longestValidParentheses(String s) {
        int result = 0;
        if(s.length() == 0) return result;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                int left = 0;
                int right = 0;
                int right1 = 0;
                int r = 0;
                int j = i;
//                List<Integer> list = new ArrayList<>();
                for (j = i;j < s.length();j++){
                    if (s.charAt(j) == '('){
                        left++;
//                        list.add(j);
                        right--;
                        r++;
                    }else {
                        left--;
                        right++;
                        right1++;
                        if (left < 0){
                            result = result > r ? result : r;
                            break;
                        }
                        r++;
                        if (left == 0) result = result > r ? result : r;
//                        else if (right == 1) i = list.get(list.size() - right) - 1;

                    }
                }
//                if (right == 0){
//                    i = j;
//                }
                if (right > 0) i = j;
                if (right1 == 0) i = j;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int s = longestValidParentheses("((()(((");
        System.out.println(s);
    }
}
