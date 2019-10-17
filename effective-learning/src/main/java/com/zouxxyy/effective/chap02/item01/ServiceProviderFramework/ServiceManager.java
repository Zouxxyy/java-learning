package com.zouxxyy.effective.chap02.item01.ServiceProviderFramework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务管理
 * 内含 服务访问API，如 getMyService，获取 MyService 服务
 * 内含 提供者注册API，如 registerProvider
 */

public class ServiceManager {

    private ServiceManager(){

    }

    private static final Map<String, ServiceProvider> providers = new ConcurrentHashMap<String, ServiceProvider>();

    public static void registerProvider(String name, ServiceProvider provider){

        providers.put(name, provider);

    }

    public static MyService getMyService(String name){

        ServiceProvider provider = providers.get(name);

        if(provider == null){
            throw new IllegalArgumentException("No provider registered with name= "+name);
        }

        return provider.getMyService();
    }

}