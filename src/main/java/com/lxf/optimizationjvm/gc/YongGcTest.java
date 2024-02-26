package com.lxf.optimizationjvm.gc;

/**
 * @Description:
 * @Author: xiaofei.li
 * @Date: 2020/12/26 11:33
 */
public class YongGcTest {

    public static void main(String[] args) {
        //1M内存 eden 占用1M
        byte[] arrary1 = new byte[1024 * 1024];
        //eden 占用1M
        arrary1 = new byte[1024 * 1024];
        //eden 占用1M
        arrary1 = new byte[1024 * 1024];
        arrary1 = null;
        //2M内存,此时 eden已经放不下，会进行一次yonggc
        byte[] arrary2 = new byte[2*1024 * 1024];
    }
}
