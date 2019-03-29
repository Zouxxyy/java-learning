package com.zouxxyy.jvm.chap4;

/**
 * 程序4-4
 * JConsole 线程死锁
 * @version 1.00 2019-03-25
 * @author zouxxyy
 */
public class JConsoleTest3 {
    static class DeadLock implements Runnable {
        final Object a, b;

        public DeadLock(Object a, Object b) {
            this.a = a;
            this.b = b;
        }

        public void run() {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("没有死锁");
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        new Thread(new DeadLock(object1, object2)).start();
        new Thread(new DeadLock(object2, object1)).start();
    }
}

/* JConsole里的
名称: Thread-1
状态: java.lang.Object@413762c7上的BLOCKED, 拥有者: Thread-0
总阻止数: 1, 总等待数: 1

堆栈跟踪:
com.zouxxyy.jvm.chap4.JConsoleTest3$DeadLock.run(JConsoleTest3.java:26)
   - 已锁定 java.lang.Object@1cdbd26d
java.lang.Thread.run(Thread.java:748)
 */