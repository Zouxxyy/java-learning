package com.zouxxyy.netty.codec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 编码解码测试
 * 客户端 write (outbound) longToByte）<- 发出long  （反着加）
 * 客户端 read （inbound）  byteToLong -> 打印long
 */
public class CodecClient {
    public static void main(String[] args) throws Exception{

        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();

            bootstrap.group(eventExecutors)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 编码（longToByte） <- 业务（发出long）   注意出站是反的
                            // 解码（byteToLong） -> 业务（打印long）
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new MyLongToByteEncoder());
                            pipeline.addLast(new MyByteToLongDecoder());
                            pipeline.addLast(new CodecClientHandler());
                        }
                    });

            System.out.println("客户端 ok...");

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 7000).sync();

            channelFuture.channel().closeFuture().sync();

        }finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
