package org.buptdavid.datastructure.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicUSFHandler implements InvocationHandler {
    private Object realObject;
    private String serviceName;

    public DynamicUSFHandler(Object realObject, String serviceName) {
        this.realObject = realObject;
        this.serviceName = serviceName;
    }

    public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
        Object object = null;
        try {
            System.out.println("before");
            object = method.invoke(this.realObject, objects);
            System.out.println("invoke");
        } catch (InvocationTargetException var13) {
            throw var13.getCause();
        }
        finally {

        }
        return object;
    }
}
