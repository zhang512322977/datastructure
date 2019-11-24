package org.buptdavid.datastructure.designPatterns.singleton.staticInnerClass;

/**
 * 静态内部类实现的线程安全的单例模式<br>
 * 由于内部静态类只会被加载一次，故是线程安全的
 * 避免了线程不安全，延迟加载，效率高。
 * @author weijielu
 *
 */
public class Singleton {
    
    private Singleton(){}
    
    private static class SingleHolder{
        static Singleton instance = new Singleton();
    }
    
    public static Singleton getInstance(){
        return SingleHolder.instance;
    }

}
