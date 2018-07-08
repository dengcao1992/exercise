package com.dcs.exercise;
/*
给定 n 个正整数 a1，a2，...，an，其中每个点的坐标用（i, ai）表示。 画 n 条直线，使得线 i 的两个端点处于（i，ai）和（i，0）处。请找出其中的两条直线，使得他们与 X 轴形成的容器能够装最多的水。



注意：你不能倾斜容器，n 至少是2。
 */
public class ZuiDaRongJi {
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;
        int r =0;
        while (j != i ){
            r = height[i] < height[j] ? height[i] : height[j];
            result = result > r*(j-i) ? result : r*(j-i);
            if (height[i] < height[j] ){
                i++;
            }else {
                j--;
            }
        }
        return result;
    }
}
