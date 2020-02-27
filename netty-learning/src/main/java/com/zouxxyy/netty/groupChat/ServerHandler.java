package com.zouxxyy.netty.groupChat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


public class ServerHandler extends SimpleChannelInboundHandler<String> {

    // 定义一个channel组，管理所有的channel
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 连接建立时，向 channelGroup 中的 channel 推送连接建立消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[用户]" + channel.remoteAddress() + " 加入聊天\n");
        channelGroup.add(channel);
    }

    /**
     * 连接断开时，向 channelGroup 中的 channel 推送连接断开消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[用户]" + channel.remoteAddress() + " 离开了~\n");
        // channelGroup.remove(channel); 该句会自动执行
    }

    /**
     * channel 处于活动状态时，服务端显示 channel 上线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 上线");
    }

    /**
     * channel 处于非活动状态时，服务端显示 channel 下线
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + " 离线~");
        System.out.println("当前在线人数：" + channelGroup.size());
    }

    /**
     * 读取消息，并转发给其它客户端
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        // 针对自己和其它客户端发不同的消息
        channelGroup.forEach(ch -> ch.writeAndFlush((ch == channel ? "[自己]" : "[用户]" )
                + channel.remoteAddress() + " 发送了消息 " + msg + "\n")
        );

        System.out.println("转发" + channel.remoteAddress() + " 的消息：" + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
