package com.lgx.miaosha.headfirst.abstractfactory;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {

    abstract ProductA createProductA();  //创建产品A的对象

    abstract ProductB createProductB();  //创建产品B的对象
}
