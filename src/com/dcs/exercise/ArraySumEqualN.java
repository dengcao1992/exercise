package com.dcs.exercise;
/*
数组和等于n的子集个数
qx（）不考虑顺序元素可重复，记忆搜索版
qx2（）不考虑顺序元素可重复，动态规划版
qxx（）考虑顺序元素可重复，记忆搜索版
qxx2（）考虑顺序元素可重复，动态规划版
qy（）不考虑顺序元素不可重复,记忆搜索版
qy2（）不考虑顺序元素不可重复,动态规划版
qyy（）考虑顺序元素不可重复
 */

public class ArraySumEqualN {
    public static int target = 4;
    public static int[] num = {1,2,3,4};
    public static int[][] q =new int[num.length][target+1];
    public static int[] qq = new int[target+1];
    public static int[][] y = new int[num.length][target+1];

    public static int qx(int i,int target){
        int p = 0;
        if (!(q[i][target] == -1)){
            return q[i][target];
        }
        for (int j = 0;j <= target/num[i];j++){
            p = p + qx(i+1,target-num[i]*j);
        }
        q[i][target] = p;
        return p;
    }

    public static int qx2(int target){
        int[][] q2 = new int[num.length][target+1];
        for (int i = 0;i < q2[0].length;i++){
            if(i%num[num.length-1] ==0){
                q2[q2.length-1][i] = 1;
            }
        }
        for (int i = q2.length-2;i >= 0;i--){
            for (int j = 0;j < q2[0].length;j++){
                for (int k = 0;k <=j/num[i];k++ ){
                    q2[i][j] = q2[i][j] + q2[i+1][j - k*num[i]];
                }
            }
        }
        return q2[0][target];
    }

    public static int qxx(int target){
        if (qq[target] != -1){
            return qq[target];
        }
        int p = 0;
        for (int i = 0;i < num.length;i++){
            if (target-num[i] < 0){
                continue;
            }
            p = p + qxx(target-num[i]);
        }
        qq[target] = p;
        return p;

    }

    public static int qxx2(int target){
        int[] qq2 =new int[target+1];
        qq2[0] = 1;
        for (int i = 1;i <= target;i++){
            for (int j = 0;j < num.length;j++){
                if (i - num[j] < 0){
                    continue;
                }
                qq2[i] = qq2[i] + qq2[i - num[j]];

            }
        }
        return qq2[target];
    }

    public static int qy (int i ,int target){
        int q = 0;
        if (target < 0){
            return 0;
        }
        if (y[i][target] != -1 ){
            return y[i][target];
        }
        q = qy(i+1,target) + qy(i+1,target-num[i]);
        y[i][target] = q;
        return q;
    }

    public static int qy2 (){
        int[][] q = new int[num.length][target+1];
        for (int i = 0;i <= target;i++){
            q[num.length-1][i] = num[num.length-1]  == i || i == 0 ? 1:0;
        }
        for (int i = q.length-2; i >= 0;i--){
            for (int j = 0;j < q[0].length;j++){
                q[i][j] = j - num[i] >= 0 ? q[i+1][j] + q[i+1][j - num[i]] : q[i+1][j];
//                System.out.println(q[i][j]);
            }

        }
        return q[0][target];
    }

    public static int qyy(int target,int[] numbers){
        int q = 0;
        int[] a = new int[numbers.length];
        for (int i = 0;i < numbers.length;i++){
            a[i] = numbers[i];
        }
        for (int i = 0;i < numbers.length;i++){
            if (numbers[i] == -1){
                continue;
            }
            if (target - numbers[i] <= 0){
                q = target - numbers[i] < 0 ? q + 0 : q + 1;
                continue;
            }
            a[i] = -1;
            q = q + qyy(target - numbers[i],a);
            a[i] = numbers[i];
        }
        return q;
    }
    
    public static void main(String[] args) {
        //初始化q[][]
        for(int g = 0; g <q.length;g++){
            for (int j = 0; j<q[0].length;j++){
                if (g==q.length-1){
                    if (j%num[g]==0){
                        q[g][j] = 1;
                        continue;
                    }
                    q[g][j] = 0;
                    continue;
                }
                q[g][j] = -1;
            }
        }
        //初始化qq[]
        qq[0] = 1;
        for (int i = 1;i < qq.length;i++){
            qq[i] = -1;
        }
        //初始化y[][]
        for(int g = 0; g <y.length;g++){
            for (int j = 0; j<y[0].length;j++){
                if (g == y.length-1){
                   y[g][j] = j%num[g] == 0 ? 1:0;
                   continue;
                }
                y[g][j] = -1;
            }
        }
        System.out.println(qx(0,target));
        System.out.println(qx2(target));
        System.out.println(qxx(target));
        System.out.println(qxx2(target));
        System.out.println(qy(0,target));
        System.out.println(qy2());
        System.out.println(qyy(target,num));

    }
}
