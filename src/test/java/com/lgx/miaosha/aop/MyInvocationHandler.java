package com.lgx.miaosha.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        return args[0] + "我很强";
    }

    void testProxy(){
        Person proxyInstance = (Person) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Person.class}, new MyInvocationHandler());
        System.out.println("前置通知");
        System.out.println(proxyInstance.show("李白啊"));
        System.out.println("后置通知");
    }

    public static void main(String[] args) {
        new MyInvocationHandler().testProxy();
    }
}
