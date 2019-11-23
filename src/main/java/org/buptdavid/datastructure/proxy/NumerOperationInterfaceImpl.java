package org.buptdavid.datastructure.proxy;

public class NumerOperationInterfaceImpl implements NumerOperationInterface {
    @Override
    public void add(int a, int b) {
        System.out.println(a+" + " + b +" = " + a+b);
    }
}
