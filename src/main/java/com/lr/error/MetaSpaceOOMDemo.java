package com.lr.error;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020-11-21 12:05
 */
public class MetaSpaceOOMDemo {
    static class MyClass{}
    public static void main(String[] args) {
        int i = 0; // 计数器
        try {
            /**
             * cglib动态代理是通过集成父类，生成子类实现的，
             * 这里就是while不断地通过enhancer动态生成static class的子类来模拟不断加载类的元数据信息到metaspace
             */
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MyClass.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invoke(o, args);
                    }
                });
                enhancer.create(); // java.lang.OutOfMemoryError: Metaspace
            }
        } catch (Throwable e) {
            System.out.println("********** " + i); // 545
            e.printStackTrace();
        } finally {
        }
    }
}
