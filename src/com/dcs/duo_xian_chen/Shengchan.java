package com.dcs.duo_xian_chen;

public class Shengchan extends Thread{
    private Rongqi rongqi;
    public Shengchan(Rongqi rongqi){
        this.rongqi = rongqi;
    }
    private void play(){
        rongqi.setValue();
        System.out.print("生产"+" ");
        rongqi.print();
    }

    @Override
    public void run() {
        while (true){
            synchronized (rongqi){
                if (rongqi.isMax()){
                    try {
                        System.out.println("满了");
                        rongqi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    play();
                    rongqi.notifyAll();
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
