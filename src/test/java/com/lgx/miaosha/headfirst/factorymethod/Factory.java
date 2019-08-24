package com.lgx.miaosha.headfirst.factorymethod;

import java.util.Calendar;

/**
 * 创建对象的工厂
 */
public abstract class Factory {

    abstract Product getProduct();

    public void doSomething(){
        //.....
    }
}
