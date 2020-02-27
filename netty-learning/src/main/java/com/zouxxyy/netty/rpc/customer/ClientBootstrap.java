package com.zouxxyy.netty.rpc.customer;

import com.zouxxyy.netty.rpc.netty.RPCClient;
import com.zouxxyy.netty.rpc.publicinterface.HelloService;

public class ClientBootstrap {

    // 协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) {

        RPCClient customer = new RPCClient();

        // 创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        // 通过代理对象调用服务提供者的方法（服务）
        String msg = "你好";
        System.out.println("远程调用 hello(\"" + msg + "\")，return：" + service.hello(msg));
        msg = "猪头";
        System.out.println("远程调用 hello(\"" + msg + "\")，return：" + service.hello(msg));
    }
}
