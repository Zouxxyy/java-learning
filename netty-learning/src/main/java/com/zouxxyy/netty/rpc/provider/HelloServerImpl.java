package com.zouxxyy.netty.rpc.provider;

import com.zouxxyy.netty.rpc.publicinterface.HelloService;

// provider 提供的服务
public class HelloServerImpl implements HelloService {
    @Override
    public String hello(String msg) {
        System.out.println("执行hello(\"" + msg + "\")");

        if ("你好".equals(msg))
            return "谢谢，你也好！";
        else
            return "对不起，听不懂你在说啥？";
    }
}
