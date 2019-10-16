package com.zouxxyy.effective.chap02.item01.ServiceProviderFramework;

/**
 * 服务接口实现
 * 我的服务接口的实现
 */

public class MyServiceImpl implements MyService {

    public void login() {
        System.out.println("登录成功");
    }

    public void register() {
        System.out.println("注册成功");
    }
}
