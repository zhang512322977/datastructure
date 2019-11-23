package org.buptdavid.datastructure.proxy;


import org.junit.Test;

import java.lang.reflect.Proxy;

public class NumberOperationImpProxyHandlerTest {


    @Test
    public void name() {


        NumerOperationInterface proxied = new NumerOperationInterfaceImpl();
        NumerOperationInterface instance = (NumerOperationInterface)Proxy.newProxyInstance(NumerOperationInterface.class.getClassLoader(),
                new Class[]{NumerOperationInterface.class},
                new NumberOperationImpProxyHandler(proxied));


        instance.add(1,2);
    }
}
