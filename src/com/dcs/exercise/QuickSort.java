package com.dcs.exercise;

import java.util.Arrays;

/**
 * Created by ycq on 2018/7/20.
 * 快速排序
 */
public class QuickSort {
    public void sort(Comparable[] inputArray){
        if (inputArray == null || inputArray.length == 0){
            return;
        }
        int begin = 0;
        int end = inputArray.length - 1;
        sort(inputArray, begin, end);
    }

    private void sort(Comparable[] inputArray, int begin, int end){
        if (begin >= end){
            return;
        }
        int less = begin + 1;
        int more = end;
        Comparable middleNum = inputArray[begin];
        while (less <= more){
            while ( less <= end && inputArray[less].compareTo(middleNum) <= 0){
                less ++;
            }
            while (more > begin && inputArray[more].compareTo(middleNum) > 0){
                more --;
            }
            if (less > more){
                continue;
            }
            swap(inputArray, less, more);
        }
        swap(inputArray, begin, more);
        sort(inputArray, begin, more - 1);
        sort(inputArray, more + 1, end);
    }

    private void swap(Comparable[] inputArray, int less, int more){
        Comparable num = inputArray[less];
        inputArray[less] = inputArray[more];
        inputArray[more] = num;
    }

    public static void main(String[] args) {
        Integer[] ints = {32, 21, 13, 12, 45, 12};
//        System.out.println(ints[0].compareTo(ints[2]));
        QuickSort quickSort = new QuickSort();
        quickSort.sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
