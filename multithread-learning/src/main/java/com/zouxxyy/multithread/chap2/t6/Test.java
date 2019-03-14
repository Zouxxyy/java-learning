package com.zouxxyy.multithread.chap2.t6;

/**
 * 程序2-6
 * 出现异常，锁自动释放
 * @version 1.00 2019-03-11
 * @author zouxxyy
 */
public class Test {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.setName("a");
            a.start();

            Thread.sleep(500);

            ThreadB b = new ThreadB(service);
            b.setName("b");
            b.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*

线程名： a 开始时间： 1552271677905
线程名： a 异常时间： 1552271678512
线程名： b 开始时间： 1552271678512
Exception in thread "a" java.lang.NumberFormatException: For input string: "a"
	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.lang.Integer.parseInt(Integer.java:580)
	at java.lang.Integer.parseInt(Integer.java:615)
	at com.zouxxyy.multithread.chap2.t6.Service.testMethod(Service.java:13)
	at com.zouxxyy.multithread.chap2.t6.ThreadA.run(ThreadA.java:12)
 */
