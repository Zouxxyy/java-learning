package com.zouxxyy.effective.chap02.item01.ServiceProviderFramework;


public class Test {

    public static void main(String[] args) throws ClassNotFoundException {

        // 执行 ServiceProviderImpl 的静态代码块里的 ServiceManager.registerProvider
        // 也就是 providers.put(name, provider);
        Class.forName("com.zouxxyy.effective.chap02.item01.ServiceProviderFramework.ServiceProviderImpl");

        // 通过服务访问API 获取 我的服务
        MyService userService = ServiceManager.getMyService("登录注册服务");

        // 使用服务
        userService.register();
        userService.login();
    }
}
