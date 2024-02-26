package com.lxf.optimizationjvm.gc;

/**
 * @Description:
 * @Author: xiaofei.li
 * @Date: 2020/12/26 14:36
 */
public class OldGcTest {
    public static void main(String[] args) {
        //2M
        byte[] arrary1 = new byte[2*1024 * 1024];
        arrary1 = new byte[2*1024 * 1024];
        arrary1 = new byte[2*1024 * 1024];
        arrary1 = null;
        //128K
        byte[] arrary2 = new byte[128 * 1024];
        //2M内存,此时 eden已经放不下，会进行一次yonggc
        byte[] arrary3 = new byte[2*1024 * 1024];
    }
}
