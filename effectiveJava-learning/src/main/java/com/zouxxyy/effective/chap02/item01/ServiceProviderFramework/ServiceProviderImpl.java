package com.zouxxyy.effective.chap02.item01.ServiceProviderFramework;

/**
 * 服务提供者接口
 */

public class ServiceProviderImpl implements ServiceProvider {

    public MyService getMyService() {

        return new MyServiceImpl();

    }

    static{
        ServiceManager.registerProvider("登录注册服务", new ServiceProviderImpl());
    }
}
