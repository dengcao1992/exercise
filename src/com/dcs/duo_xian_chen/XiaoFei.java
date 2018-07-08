package com.dcs.duo_xian_chen;

public class XiaoFei extends Thread{
    private Rongqi rongqi;
    public XiaoFei(Rongqi rongqi){
        this.rongqi = rongqi;
    }
    private void eat(){
        rongqi.getValue();
        System.out.print("消费"+" ");
        rongqi.print();
    }

    @Override
    public void run() {
        while (true){
            synchronized (rongqi){
                if (rongqi.isEmpty()){
                    try {
                        System.out.println("空了");
                        rongqi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    eat();
                    rongqi.notifyAll();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
