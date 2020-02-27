package com.zouxxyy.netty.rpc.provider;

import com.zouxxyy.netty.rpc.netty.RPCServer;

// 启动provider（NettyServer）
public class ServerBootstrap {
    public static void main(String[] args) {
        RPCServer.startServer("127.0.0.1", 7000);
    }
}
