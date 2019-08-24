package com.lgx.miaosha.headfirst.factorymethod;

/**
 * 具体创建对象的工厂的子类   创建产品B的对象
 */
public class ConcreteFactoryB extends Factory {
    @Override
    Product getProduct() {
        return new ProductB();
    }
}
