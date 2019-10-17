package com.zouxxyy.effective.chap02.item01.ServiceProviderFramework;

/**
 * 第五大优势例子：方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在
 * 例子：服务提供者框架
 */

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        // 1. 执行 ServiceProviderImpl 的静态代码块里的:
        // ServiceManager.registerProvider("登录注册服务", new ServiceProviderImpl());
        // 即 providers.put(name, provider); 将服务提供者接口添加到注册列表中
        Class.forName("com.zouxxyy.effective.chap02.item01.ServiceProviderFramework.ServiceProviderImpl");

        // 2. 通过服务访问API 获取 我的服务
        // 可以发现这里该静态工厂方法获取的类可以不存在，改由中间层 provider 获取，实现接耦
        MyService userService = ServiceManager.getMyService("登录注册服务");

        // 3. 使用服务
        userService.register();
        userService.login();
    }
}


/*
成功注册 登录注册服务
注册成功
登录成功
 */