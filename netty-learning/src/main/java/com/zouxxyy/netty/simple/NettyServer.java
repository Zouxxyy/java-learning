package com.zouxxyy.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * tcp服务器
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        // 两个线程组：bossGroup 处理连接请求，workGroup 处理业务
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(2);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)          // 服务器等待队列大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  // 保持连接对象
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            System.out.println("服务器 is ready...");

            ChannelFuture cf = bootstrap.bind(6668).sync();

            // Future-listener 机制测试
            cf.addListener(future -> {
                if (future.isSuccess()) {
                    System.out.println("绑定端口 " + 6668 + " 成功");
                }
                else {
                    System.out.println("绑定端口失败");
                }
            });

            cf.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
