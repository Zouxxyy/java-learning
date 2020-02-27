package com.zouxxyy.netty.async;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 自定义handler
 */
public class
AsyncServerHandler extends ChannelInboundHandlerAdapter {

    // handle中的业务线程池
    static final EventExecutorGroup group = new DefaultEventExecutorGroup(4);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead 开始，线程是 " + Thread.currentThread().getName());

        // 1. 把任务放入taskQueue 和 scheduleTaskQueue中
        ctx.channel().eventLoop().execute(() -> {
            try {
                System.out.println("taskQueue复杂任务开始...");
                System.out.println("当前线程是 " + Thread.currentThread().getName());
                Thread.sleep(10 * 1000);
                System.out.println("taskQueue复杂任务结束!");
                ctx.writeAndFlush(Unpooled.copiedBuffer("taskQueue 复杂任务的回复", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        ctx.channel().eventLoop().schedule(() -> {
//            try {
//                System.out.println("scheduleTaskQueue复杂任务开始...");
//                System.out.println("当前线程是 " + Thread.currentThread().getName());
//                Thread.sleep(10 * 1000);
//                System.out.println("scheduleTaskQueue复杂任务结束!");
//                ctx.writeAndFlush(Unpooled.copiedBuffer("scheduleTaskQueue 中的复杂任务的回复", CharsetUtil.UTF_8));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 5, TimeUnit.SECONDS);

        // 2. 把任务放入handle中的业务线程池
        // 注意里面的write操作会被封装成 Task，仍然在 nioEventLoop 线程中执行！！
        group.submit(() -> {
            try {
                System.out.println("业务线程池复杂任务开始...");
                System.out.println("当前线程是 " + Thread.currentThread().getName());
                Thread.sleep(5 * 1000);
                System.out.println("业务线程池复杂任务结束!");
                ctx.writeAndFlush(Unpooled.copiedBuffer("业务线程池 复杂任务的回复", CharsetUtil.UTF_8));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });

        System.out.println("go on ...");
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息的：" + buf.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        System.out.println("channelRead 结束，进行回复");
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端~", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
