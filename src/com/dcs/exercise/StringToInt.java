package com.dcs.exercise;
/*
这个函数需要丢弃之前的空白字符，直到找到第一个非空白字符。之后从这个字符开始，选取一个可选的正号或负号后面跟随尽可能多的数字，并将其解释为数字的值。

字符串可以在形成整数的字符后包括多余的字符，将这些字符忽略，这些字符对于函数的行为没有影响。

如果字符串中的第一个非空白的字符不是有效的整数，或者没有这样的序列存在，字符串为空或者只包含空白字符则不进行转换。

如果不能执行有效的转换，则返回 0。如果正确的值超过的可表示的范围，则返回 INT_MAX（2147483647）或 INT_MIN（-2147483648）。
 */
public class StringToInt {
    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int i = 0;
        long result = 0;
        int p = 1;
        while (str.charAt(i) == ' '){
            i++;
            if(i == str.length()) return 0;
        }
        if ( !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-'){
                p = str.charAt(i) == '+'?1:-1;
                i++;
            }else {
                return 0;
            }
        }
        for (int j = i;j < str.length(); j++){
            if ( str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                result = result*10 + (str.charAt(j) - '0');
                if (p*result > Integer.MAX_VALUE || p*result < Integer.MIN_VALUE){
                    return p*result > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else {
                break;
            }
        }
        return (int) result*p;
    }

    public static void main(String[] args) {
//        System.out.println('1' != '-' && !('1' >= '0' && '1' <= '9'));
        int i = myAtoi("");
        System.out.println(i);
    }
}
