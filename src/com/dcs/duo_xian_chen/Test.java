package com.dcs.duo_xian_chen;

public class Test {
    public static void main(String[] args) {
        Rongqi rongqi = new Rongqi(10);
        Shengchan shengchan = new Shengchan(rongqi);
        XiaoFei xiaoFei = new XiaoFei(rongqi);
        XiaoFei xiaoFei2 = new XiaoFei(rongqi);
        XiaoFei xiaoFei3 = new XiaoFei(rongqi);
        XiaoFei xiaoFei4 = new XiaoFei(rongqi);
        shengchan.start();
        xiaoFei.start();
        xiaoFei2.start();
        xiaoFei3.start();
        xiaoFei4.start();
    }
}
