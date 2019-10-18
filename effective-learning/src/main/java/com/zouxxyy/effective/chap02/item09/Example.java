package com.zouxxyy.effective.chap02.item09;

/**
 * try-with-resources优先与try-finally
 */

public class Example {

    public static void tryFinally() throws Exception {

        MyResource myResource1 = new MyResource();
        System.out.println("try-finally 测试");
        try {
            myResource1.play();
        }
        finally {
            myResource1.close();
        }
    }

    public static void tryWithResource() {
        System.out.println("try-with-resources 测试");

        try (MyResource myResource2 = new MyResource()) {
            myResource2.play();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        // Example.tryFinally();

        // 从输出可以发现，close方法的异常，抹去了play方法的异常，我们无法知道出异常的原因

        Example.tryWithResource();

        // 从输出可以发现，优先抛play异常，在Suppressed中有close异常。这就很舒服

    }
}

// 要用try-with-resources，需要实现AutoCloseable接口
class MyResource implements AutoCloseable {

    public void play() throws Exception {
        System.out.println("执行play方法");
        throw new Exception("执行play异常");
    }

    // 模拟关闭资源函数
    @Override
    public void close() throws Exception {
        System.out.println("执行close方法");
        throw new Exception("执行close异常");
    }
}

// 这哥们解释的很好：https://miaoxinguo.github.io/java/2016/03/31/try.with.resource.html

/*
try-finally 测试
执行play方法
执行close方法
Exception in thread "main" java.lang.Exception: 执行close异常
	at com.zouxxyy.effective.chap02.item09.MyResource.close(Example.java:56)
	at com.zouxxyy.effective.chap02.item09.Example.tryFinally(Example.java:14)
	at com.zouxxyy.effective.chap02.item09.Example.main(Example.java:32)


try-with-resources 测试
执行play方法
执行close方法
java.lang.Exception: 执行play异常
	at com.zouxxyy.effective.chap02.item09.MyResource.play(Example.java:49)
	at com.zouxxyy.effective.chap02.item09.Example.tryWithResource(Example.java:22)
	at com.zouxxyy.effective.chap02.item09.Example.main(Example.java:36)
	Suppressed: java.lang.Exception: 执行close异常
		at com.zouxxyy.effective.chap02.item09.MyResource.close(Example.java:56)
		at com.zouxxyy.effective.chap02.item09.Example.tryWithResource(Example.java:23)
		... 1 more
 */