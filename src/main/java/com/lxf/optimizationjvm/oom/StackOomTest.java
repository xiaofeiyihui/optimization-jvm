package com.lxf.optimizationjvm.oom;

/**
 * @Description: 通过递归调用 模拟线程栈OOM
 * 设置jvm 参数 ：-XX:ThreadStackSize=1M
 * @Author: xiaofei.li
 * @Date: 2020/12/27 16:27
 */
public class StackOomTest {
    public static long counter = 0;
    public static void main(String[] args) {
        work();
    }

    public static void work() {
        System.out.println("第"+ (++counter) +"次调用方法");
        work();
    }
}
