package com.dcs;
import java.util.*;
public class Solution {
    //Insert one char from stringstream
    private static List<Character> list= new LinkedList<>();
    private static List<Integer> listInt = new ArrayList<Integer>();
    public static void Insert(char ch)
    {
        if(!list.contains(ch)){
            list.add(ch);
            listInt.add(1);
        }else{
            int i = list.indexOf(ch);
            listInt.set(i, listInt.get(i) + 1);
        }

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        char res = '#';
        for(int i = 0; i< list.size();i++){


            if(listInt.get(i)==1) {
                res = list.get(i);
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int i = -2000000000;
            System.out.println(i>>>30);
        }

    }
