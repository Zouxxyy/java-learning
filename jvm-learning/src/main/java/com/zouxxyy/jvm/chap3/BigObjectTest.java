package com.zouxxyy.jvm.chap3;

/**
 * 程序3-4
 * 大对象直接进入老年代
 * @version 1.00 2019-03-23
 * @author zouxxyy
 */
public class BigObjectTest {
    public static void main(String[] args) {
        // 设置了大对象边界为3M
        byte[] allocation = new byte[4 * 1024 * 1024];
        System.gc();
    }
}

/*
VM options: -verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:PretenureSizeThreshold=3M
 */

/*
[Full GC (System.gc()) [Tenured: 4096K->4581K(10240K), 0.0028293 secs] 6323K->4581K(19456K), [Metaspace: 3295K->3295K(1056768K)], 0.0028905 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 246K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,   3% used [0x00000007bec00000, 0x00000007bec3d8e0, 0x00000007bf400000)
  from space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
  to   space 1024K,   0% used [0x00000007bf500000, 0x00000007bf500000, 0x00000007bf600000)
 tenured generation   total 10240K, used 4581K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  44% used [0x00000007bf600000, 0x00000007bfa797c0, 0x00000007bfa79800, 0x00000007c0000000)
 Metaspace       used 3308K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 365K, capacity 388K, committed 512K, reserved 1048576K
 */