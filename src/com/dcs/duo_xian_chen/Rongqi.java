package com.dcs.duo_xian_chen;

public class  Rongqi {
    private int value;
    private int max;
    public Rongqi(int max){
        this.max = max;
    }
    public void setValue(){
        value++;
    }
    public void getValue(){
        value--;
    }
    public boolean isMax(){
        return value == max;
    }
    public boolean isEmpty(){
        return value == 0;
    }
    public void print(){
        System.out.println(value);
    }
}
