package com.dcs.appjia;
/*
给定任意一个自然数，获取它重新排列后，下一个比它大的自然数，要求时间复杂度O(n)。例如：
        给定1233,它的下一个是1323；
        给定1323,它的下一个是1332；
        给定876,它的下一个不存在；
 */
public class NextNum {
    public long getNextNum(long input){
        long result = 0;
        if (input < 0){
            return result;
        }
        result = found(input, 1);
        return result;
    }

    private long found(long input, int begin){
        long result = 0;
        int swapA = getNum(input, begin);
        if (swapA == -1){
            return result;
        }
        int swapB = 10;
        int swapBPlace = 0;
        for (int i = begin - 1; i > -1; i --){
            int OneSwapB = getNum(input, i);
            if (OneSwapB == -1){
                break;
            }
            if (OneSwapB > swapA && OneSwapB < swapB){
                swapB = OneSwapB;
                swapBPlace = i;
            }
        }
        if (swapB != 10){
            result = swap(input, begin, swapBPlace, swapA, swapB);
            return result;
        }
        result = found(input, begin + 1);
        return result;
    }

    private int getNum(long input, int place){
        long result = input;
        long quotient = input;
        long divisor = 1;
        for (int i = 0; i < place; i ++){
            result /= 10;
        }
        if (result == 0){
            return -1;
        }
        return (int)result % 10;
    }

    private long swap(long input, int a, int b, int swapA, int swapB){
        long result = 0;
        int place = 0;
        int remainder = getNum(input, place);
        while (remainder != -1){
            long num = remainder;
            if (place == a || place == b){
                num = place == a ? swapB : swapA;
            }
            for (int i = 0; i < place; i ++){
                num *= 10;
            }
            result += num;
            place++;
            remainder = getNum(input, place);
        }
        return result;
    }

    public static void main(String[] args) {
        NextNum nextNum = new NextNum();
        System.out.println(nextNum.getNextNum(12222233));

    }
}
