package com.dcs.exercise;

public class DianDaoShu {
    public static int reverse(int x) {
        int result = 0;
        String s = Integer.toString(x);
        String r = "";
        if (s.length() == 1) return x;
        for (int i = s.length()-1;i >= 0;i-- ){
            if (i == s.length()-1 && s.charAt(i) == '0') continue;
            if (i == 0 && s.charAt(i) == '-'){
                r = s.charAt(i) + r;
                break;
            }
            r = r + s.charAt(i);
        }
        long re = Long.valueOf(r);
        if (re > (long)Integer.MAX_VALUE || re < (long)Integer.MIN_VALUE) return result;
        result = Integer.valueOf(r);
        return result;
    }

    public static void main(String[] args) {
        int i = reverse(123);
        System.out.println(i);
    }
}
