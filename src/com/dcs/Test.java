package com.dcs;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static boolean pip(int i ,int j,String input1,String input2){
        boolean res = false;
        if (i > input1.length() -1 || j > input2.length() - 1) return false;
        if (input1.charAt(i) != input2.charAt(j)) {
            if (input2.charAt(j) == '?') {
                if (i == input1.length() - 1 && j == input2.length() - 1){
                    return true;
                }
                if (i == input1.length() - 1){
                    for (int k = j + 1; k < input2.length();k++){
                        if (input2.charAt(k) == '*') {
                            if (k == input2.length() - 1) return true;
                            continue;
                        }else {
                            break;
                        }
                    }
                }
                res = pip(i+1,j+1,input1,input2);
            }else if (input2.charAt(j) == '*') {
                for (int k = i;k < input1.length();k++){
                    if (j == input2.length() - 1) return true;
                    res = pip(k,j+1,input1,input2);
                    if (res) break;
                }
            }else {
                return false;
            }
        }else {
            if (i == input1.length() - 1 && j == input2.length() - 1){
                return true;
            }
            if (i == input1.length() - 1){
                for (int k = j + 1; k < input2.length();k++){
                    if (input2.charAt(k) == '*') {
                        if (k == input2.length() - 1) return true;
                        continue;
                    }else {
                        break;
                    }
                }
            }
            res = pip(i+1,j+1,input1,input2);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        boolean res = false;
        if (input1.length() > 0 && input2.length()> 0){
            res = pip(0,0,input1,input2);
        }
        System.out.println(res);
    }
}


