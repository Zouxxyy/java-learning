package com.zouxxyy.jvm.chap3;

/**
 * 程序3-1
 * 看是不是引用计数
 * @version 1.00 2019-03-22
 * @author zouxxyy
 */
public class GCTest {

    private Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        GCTest testGC1 = new GCTest();
        GCTest testGC2 = new GCTest();

        testGC1.instance = testGC2;
        testGC2.instance = testGC1; // 相互引用

        testGC1 = null; // 外部引用失效
        testGC2 = null;

        System.gc();
    }
}

/*
VM options :  -verbose:gc -XX:+PrintGCDetails
 */

/*
[GC (System.gc()) [PSYoungGen: 7424K->624K(38400K)] 7424K->632K(125952K), 0.0357820 secs] [Times: user=0.01 sys=0.00, real=0.04 secs]
[Full GC (System.gc()) [PSYoungGen: 624K->0K(38400K)] [ParOldGen: 8K->481K(87552K)] 632K->481K(125952K), [Metaspace: 3288K->3288K(1056768K)], 0.0045521 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen      total 38400K, used 998K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 3% used [0x0000000795580000,0x0000000795679b20,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 481K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740078718,0x0000000745580000)
 Metaspace       used 3297K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 362K, capacity 388K, committed 512K, reserved 1048576K
 */