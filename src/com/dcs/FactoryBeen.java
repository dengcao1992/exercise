package com.dcs;

/**
 * Created by ycq on 2018/7/21.
 */
public class FactoryBeen {
    private static final FactoryBeen factoryBeen = new FactoryBeen();
    private FactoryBeen(){}
    public static FactoryBeen getFactoryBeen(){
        return factoryBeen;
    }
}
