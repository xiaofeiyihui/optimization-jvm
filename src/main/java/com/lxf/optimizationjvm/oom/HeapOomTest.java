package com.lxf.optimizationjvm.oom;

import java.util.ArrayList;

/**
 * @Description: 不停的创建对象，应用也不释放，每次触发gc的时候，都回收不了对象，最后对象进入老年代，再触发FullGC还是没办法回收，然后堆就OOM
 *设置jvm参数：-Xms10M -Xmx10M
 * @Author: xiaofei.li
 * @Date: 2020/12/27 16:35
 */
public class HeapOomTest {
    public static void main(String[] args) {
        long counter = 0;
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Object());
            System.out.println("当前创建了第："+(++counter)+"个对象");
        }
    }
}
