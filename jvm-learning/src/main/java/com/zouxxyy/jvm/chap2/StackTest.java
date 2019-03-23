package com.zouxxyy.jvm.chap2;

/**
 * 程序2-1
 * 栈溢出(StackOverflowError)
 * @version 1.00 2019-03-21
 * @author zouxxyy
 */
public class StackTest {

    static private void test() {
        System.out.println("方法执行...");
        test(); // 无限递归
    }

    public static void main(String[] args) {
        StackTest.test();
    }
}

/*
方法执行...
方法执行...
...
*** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
*** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
*** java.lang.instrument ASSERTION FAILED ***: "!errorOutstanding" with message transform method call failed at JPLISAgent.c line: 844
Exception in thread "main" java.lang.StackOverflowError
	at sun.nio.cs.UTF_8$Encoder.encodeLoop(UTF_8.java:691)
	at java.nio.charset.CharsetEncoder.encode(CharsetEncoder.java:579)
	at sun.nio.cs.StreamEncoder.implWrite(StreamEncoder.java:271)
	at sun.nio.cs.StreamEncoder.write(StreamEncoder.java:125)
	at java.io.OutputStreamWriter.write(OutputStreamWriter.java:207)
	at java.io.BufferedWriter.flushBuffer(BufferedWriter.java:129)
	at java.io.PrintStream.write(PrintStream.java:526)
	at java.io.PrintStream.print(PrintStream.java:669)
	at java.io.PrintStream.println(PrintStream.java:806)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:12)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
	at com.zouxxyy.jvm.chap2.Stack.StackTest.test(StackTest.java:13)
...
 */