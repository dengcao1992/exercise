package com.dcs.appjia;

public class Rank {
    public void getOut(String input) {
        if (input == null || input == "") {
            return;
        }
        char[] inputChars = input.toCharArray();
        rankString(inputChars, 0);
    }

    private void rankString(char[] inputChars, int step){
        if (step == inputChars.length - 1){
            sout(inputChars);
            return;
        }
        for (int i = step + 1; i < inputChars.length; i ++){
            if (inputChars[step] != inputChars[i]){
                swapAndSout(inputChars, step, i);
            }
        }
        rankString(inputChars, step + 1);
    }

    private void swapAndSout(char[] inputChars, int a, int b){
        char[] outputChars = copy(inputChars);
        char c = outputChars[a];
        outputChars[a] = outputChars[b];
        outputChars[b] = c;
        sout(outputChars);
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
        rank.getOut("aabb");
    }
}
