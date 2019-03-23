package com.zouxxyy.jvm.chap3;

/**
 * 程序3-3
 * 优先分配在Eden
 * @version 1.00 2019-03-23
 * @author zouxxyy
 */
public class EdenTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * 1024 * 1024]; // 分配到Eden
        allocation2 = new byte[2 * 1024 * 1024]; // 分配到Eden
        allocation3 = new byte[2 * 1024 * 1024]; // 分配到Eden
        // 4超过内存范围，新生代发生MinorGC，但Survivor不够通过内存担保转移到老年区
        allocation4 = new byte[4 * 1024 * 1024]; // 分配到Eden

        System.gc();
    }
}

/*
VM options: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M
 */

/*
[GC (Allocation Failure) --[PSYoungGen: 8174K->8174K(9216K)] 12270K->16366K(19456K), 0.0048813 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[Full GC (Ergonomics) [PSYoungGen: 8174K->2525K(9216K)] [ParOldGen: 8192K->8192K(10240K)] 16366K->10717K(19456K), [Metaspace: 3189K->3189K(1056768K)], 0.0051525 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
[GC (System.gc()) --[PSYoungGen: 2631K->2631K(9216K)] 10823K->10831K(19456K), 0.0013398 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (System.gc()) [PSYoungGen: 2631K->2524K(9216K)] [ParOldGen: 8200K->8193K(10240K)] 10831K->10718K(19456K), [Metaspace: 3227K->3227K(1056768K)], 0.0046032 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
Heap
 PSYoungGen      total 9216K, used 2688K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 32% used [0x00000007bf600000,0x00000007bf8a02c8,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
  to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 ParOldGen       total 10240K, used 8193K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 80% used [0x00000007bec00000,0x00000007bf400668,0x00000007bf600000)
 Metaspace       used 3275K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 360K, capacity 388K, committed 512K, reserved 1048576K
 */