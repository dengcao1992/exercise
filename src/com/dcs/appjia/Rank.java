package com.dcs.appjia;
/*
给定一个由字母和数字组成的字符串，打印所有可能的排列情况。
例如给定"abb",所有排列为"abb","bab","bba"，注意：只有3种输出。
 */
public class Rank {
    public void getOut(String input) {
        if (input == null || input == "") {
            return;
        }
        char[] inputChars = input.toCharArray();
        sout(inputChars);
        rankString(inputChars, 0);
    }

    private void rankString(char[] inputChars, int step){
        int[] asciis = new int['z' - '0' + 1];
        if (step == inputChars.length - 1){
            return;
        }
        asciis[inputChars[step] - '0'] = 1;
        for (int i = step + 1; i < inputChars.length; i ++){
            if (asciis[inputChars[i] - '0'] != 1){
                char[] outputChars = swapAndSout(inputChars, step, i);
                asciis[inputChars[i] - '0'] = 1;
                rankString(outputChars, step + 1);
            }
        }
        rankString(inputChars, step + 1);
    }

    private char[] swapAndSout(char[] inputChars, int a, int b){
        char[] outputChars = copy(inputChars);
        char c = outputChars[a];
        outputChars[a] = outputChars[b];
        outputChars[b] = c;
        sout(outputChars);
        return outputChars;
    }

    private char[] copy(char[] chars){
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i ++){
            result[i] = chars[i];
        }
        return result;
    }

    private void sout(char[] outputChars){
        for (char c : outputChars){
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Rank rank = new Rank();
        rank.getOut("1234");
    }
}
