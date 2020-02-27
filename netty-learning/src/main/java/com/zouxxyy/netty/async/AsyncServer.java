package com.zouxxyy.netty.async;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * 异步测试 服务器
 */
public class AsyncServer {

    // 业务线程池
    static final EventExecutorGroup group = new DefaultEventExecutorGroup(4);

    public static void main(String[] args) throws InterruptedException {

        // 两个线程组：bossGroup 处理连接请求，workGroup 处理业务
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(4);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)          // 服务器等待队列大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true)  // 保持连接对象
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new AsyncServerHandler());
                            // 3. 整个handler都加入业务线程池中
                            // pipeline.addLast(group, new AsyncServerHandler());
                        }
                    });

            System.out.println("服务器 is ready...");

            ChannelFuture cf = bootstrap.bind(6668).sync();

            cf.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
