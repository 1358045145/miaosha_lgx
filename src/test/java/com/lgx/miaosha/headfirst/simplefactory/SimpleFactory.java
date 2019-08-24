package com.lgx.miaosha.headfirst.simplefactory;

/**
 * 简单工厂 具体去创建对象的内部细节对客户是屏蔽的，只提供一个创建对象的接口。
 * 将创建对象的代码封装到一个类中，这个类叫简单工厂类。由简单工厂来指定创建哪一个类的对象
 */
public class SimpleFactory {

    /**
     * 指定创建哪个类的实例
     * @param type
     * @return
     */
    public Product createProduct(int type){
        if (type == 1)
            return new ProductA();
        if (type == 2)
            return new ProductB();
        else
            return new ProductC();
    }
}
