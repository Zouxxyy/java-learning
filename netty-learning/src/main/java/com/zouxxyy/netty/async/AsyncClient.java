package com.zouxxyy.netty.async;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 客户端
 */
public class AsyncClient {
    public static void main(String[] args) throws Exception {
        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new AsyncClientHandler());
                        }
                    });

            System.out.println("客户端 ok..");

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();

            channelFuture.channel().closeFuture().sync();

        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
