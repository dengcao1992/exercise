package com.dcs.exercise;

import com.dcs.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。

注意：结果不能包括重复的三个数的组合。
 */
public class SanShuHe {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if (nums.length < 3) return result;
        List<Integer> num1 = new ArrayList();
        List<Integer> num2 = new ArrayList();
        Map<Integer,Integer> c = new HashMap();
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0;i < nums.length;i++){
            if (c.containsKey(nums[i])){
                if (c.get(nums[i]) >= 2) {
                    if (nums[i] == 0) c.put(nums[i],3);
                    continue;
                }
                c.put(nums[i],2);
                continue;
            }
            c.put(nums[i],1);
            if (nums[i] >= 0) num1.add(nums[i]);
            else num2.add(nums[i]);
            
        }
        for (int i = 0;i < num1.size();i++){
            x = num1.get(i);
            if (c.get(x) >= 2){
                if (c.get(x) == 3){
                    List<Integer> r = new ArrayList();
                    r.add(0);
                    r.add(0);
                    r.add(0);
                    result.add(r);
                }
                z = 0 - x - x;
                if (c.containsKey(z)){
                    if (z != x){
                        List<Integer> r = new ArrayList();
                        r.add(x);
                        r.add(x);
                        r.add(z);
                        result.add(r);
                    }
                }
            }
            for (int j = i + 1;j < num1.size();j++){
                y = num1.get(j);
                z = 0 - x - y;
                if (c.containsKey(z)){
                    if (z != x && z != x){
                        List<Integer> r = new ArrayList();
                        r.add(x);
                        r.add(y);
                        r.add(z);
                        result.add(r);
                    }
                }
            }
        }
        for (int i = 0;i < num2.size();i++){
            x = num2.get(i);
            if (c.get(x) >= 2){
                if (c.get(x) == 3){
                    List<Integer> r = new ArrayList();
                    r.add(0);
                    r.add(0);
                    r.add(0);
                    result.add(r);
                }
                z = 0 - x - x;
                if (c.containsKey(z)){
                    if (z != x){
                        List<Integer> r = new ArrayList();
                        r.add(x);
                        r.add(x);
                        r.add(z);
                        result.add(r);
                    }
                }
            }
            for (int j = i + 1;j < num2.size();j++){
                y = num2.get(j);
                z = 0 - x - y;
                if (c.containsKey(z)){
                    if (z != x && z != x){
                        List<Integer> r = new ArrayList();
                        r.add(x);
                        r.add(y);
                        r.add(z);
                        result.add(r);
                    }
                }
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] s = {-2,0,1,1,2};
        List<List<Integer>> l = threeSum(s);
        for (int i = 0;i < l.size();i++){
            System.out.println(l.get(i).toString());
        }
    }
}
