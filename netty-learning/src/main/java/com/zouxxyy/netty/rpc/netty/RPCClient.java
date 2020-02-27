package com.zouxxyy.netty.rpc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RPCClient {

    // 线程池，用于提交handler
    private static ExecutorService executor = Executors.newFixedThreadPool(4);

    private static RPCClientHandler clientHandler;

    // 使用代理模式获取代理对象
    // 然后通过调用 customer.getBean(HelloService.class, providerName).hello(args)
    // 执行 (proxy, hello, args) -> {}
    public Object getBean(final Class<?> serviceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serviceClass}, (proxy, method, args) -> {
                    if (clientHandler == null) {
                        initClient();
                    }
                    clientHandler.setPara(providerName + args[0]);
                    return executor.submit(clientHandler).get();
                });
    }

    private static void initClient() {
        clientHandler = new RPCClientHandler();

        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(clientHandler);
                        }
                    });

            System.out.println("客户端 ok..");

            bootstrap.connect("127.0.0.1", 7000).sync();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

