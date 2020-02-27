package com.zouxxyy.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        // 1. http 编-解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        // 2. 自定义的Handler
        pipeline.addLast("MyHttpServerHandler", new HttpServerHandler());

        System.out.println("...initChannel ok");
    }
}
