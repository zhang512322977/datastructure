package org.buptdavid.datastructure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        String dsfBeanName = "";
        HelloService realSubject = new HelloServiceImpl();
        InvocationHandler handler = new DynamicUSFHandler(realSubject, dsfBeanName);
        HelloService realSubject1 =(HelloService) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
        realSubject1.sayHello();
    }

}
