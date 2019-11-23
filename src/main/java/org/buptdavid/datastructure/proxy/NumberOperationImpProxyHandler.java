package org.buptdavid.datastructure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NumberOperationImpProxyHandler implements InvocationHandler {

    Object proxy;

    public NumberOperationImpProxyHandler(Object proxy) {
        this.proxy = proxy;
    }

    @Override
    public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前");
        //System.out.println(proxy1);
        return method.invoke(proxy,args);
    }
}
