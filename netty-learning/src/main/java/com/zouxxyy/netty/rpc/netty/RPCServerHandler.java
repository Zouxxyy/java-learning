package com.zouxxyy.netty.rpc.netty;

import com.zouxxyy.netty.rpc.provider.HelloServerImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class RPCServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println("收到客户端请求：" + msg);
        // 得到解码后的消息，按规定的协议调用服务
        // 比如 "HelloService#hello#你好"，就会调用 HelloServerImpl().hello("你好")
        if (msg.toString().startsWith("HelloService#hello#")) {

            String message = msg.toString().substring(msg.toString().lastIndexOf("#") + 1);

            String result = new HelloServerImpl().hello(message);

            System.out.println("返回执行结果");

            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
