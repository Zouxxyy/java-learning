package com.zouxxyy.netty.codec;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 编码解码测试
 * 服务端 read （inbound）  byteToLong -> 打印long
 * 服务端 write (outbound) longToByte）<- 回复long  （反着加）
 */
public class CodecServer {

    public static void main(String[] args) throws Exception{
        // 两个线程组：bossGroup 处理连接请求，workGroup 处理业务
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup(2);

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 解码(byteToLong) -> 业务(打印long)
                            // 编码(longToByte) <- 业务(回复long)
                            pipeline.addLast(new MyByteToLongDecoder());
                            pipeline.addLast(new MyLongToByteEncoder());
                            pipeline.addLast(new CodecServerHandler());
                        }
                    });

            System.out.println("服务器 is ready...");

            ChannelFuture cf = bootstrap.bind(7000).sync();

            cf.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
