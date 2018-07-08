package com.dcs.jian_zhi_offer;
/*
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,
让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且
不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下
最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class YuanQuanYouXi {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
//        if (m  < n ) return -1;
        Boy begin = null;
        Boy before = null;
        for (int i = 0;i < n;i++){
            if (before == null){
                before = new Boy(i);
                begin = before;
            }else {
                Boy boy = new Boy(i);
                before.next = boy;
                before = boy;
            }
        }
        before.next = begin;
        for (int i = 1;i < n;i++){
            for (int j = 0;j <= m - 1;j++){
                before = begin;
                begin = begin.next;
            }
            before.value = begin.value;
            before.next = begin.next;
        }
        return before.value;
    }
    class Boy{
        int value;
        Boy next;
        public Boy(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        YuanQuanYouXi a = new YuanQuanYouXi();
        System.out.println(a.LastRemaining_Solution(5,3));
    }
}
