package com.lgx.miaosha.headfirst.simplefactory;

public class Client {

    public static void main(String[] args) {

        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        System.out.println(product.getClass().getSimpleName());  //ProductA
        Product product1 = simpleFactory.createProduct(2);
        System.out.println(product1.getClass().getSimpleName());  //ProductB
        Product product2 = simpleFactory.createProduct(3);
        System.out.println(product2.getClass().getSimpleName());  //ProductC
    }
}
