package com.lgx.miaosha.headfirst.factorymethod;

/**
 * 具体创建对象的工厂的子类   创建产品A的对象
 */
public class ConcreteFactoryA extends Factory {

    @Override
    Product getProduct() {
        return new ProductA();
    }
}
