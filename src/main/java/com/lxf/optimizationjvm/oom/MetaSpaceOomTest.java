package com.lxf.optimizationjvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: 通过动态代理不同生成类，造成metaspace 发生OOM
 * 设置jvm 参数：-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @Author: xiaofei.li
 * @Date: 2020/12/27 15:48
 */
public class MetaSpaceOomTest {
    public static void main(String[] args) {
        long counter =0;
        while (true) {
            System.out.println("目前创建了："+ (++counter) +"car类的子类了");
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Car.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    if (method.getName().equals("run")) {
                        System.out.println("之前，先进行安全检查……");
                        return methodProxy.invokeSuper(o, objects);
                    } else {
                        return methodProxy.invokeSuper(o, objects);
                    }
                }
            });
        }

    }

    static class Car {
        public void run() {
            System.out.println("汽车启动，开始行驶……");
        }
    }
}
