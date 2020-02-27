package com.zouxxyy.netty.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class RPCClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext context;
    private String result;
    private String para; // 客户端调用方法时的参数

    // 1 建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    // 4 收到回复后调用 channelRead，唤醒wait
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify(); // 唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    // 3 被代理对象调用，等待唤醒
    // 5 被唤醒
    @Override
    public synchronized Object call() throws Exception {

        context.writeAndFlush(para);
        wait(); // 等 notify()
        return result;
    }

    // 2 设置参数
    void setPara(String para) {
        this.para = para;
    }
}
