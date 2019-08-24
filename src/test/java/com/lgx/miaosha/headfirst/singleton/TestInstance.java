package com.lgx.miaosha.headfirst.singleton;

public class TestInstance {

    public static void main(String[] args) {

        SingletonLock instance1 = SingletonLock.getInstance();

        SingletonLock instance2 = SingletonLock.getInstance();

        System.out.println(instance1 == instance2);  //true

    }
}
