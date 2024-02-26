package com.lxf.optimizationjvm.gc;

/**
 * @Description:
 * @Author: xiaofei.li
 * @Date: 2020/12/26 19:35
 */
public class JvmToolTest {
    public static void main(String[] args) throws Exception{
        Thread.sleep(30000);
        while (true) {
            loadData();
        }
    }

    public static void loadData() throws Exception {
        byte[] data=null;
        for (int i = 0; i < 50; i++) {
            //100k数组
            data = new byte[100*1024];
        }
        data =null;
        Thread.sleep(1000);
    }
}
