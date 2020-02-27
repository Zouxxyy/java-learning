package com.zouxxyy.nio.groupchat;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * 群聊系统服务端
 */

public class Server {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 6667;

    /**
     * 服务器初始化
     */
    public Server() {
        try {
            // 获取 selector
            selector = Selector.open();
            // 获取 ServerSocketChannel
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务器开始监听
     */
    public void listen() {
        try {
            while (true) {
                if (selector.select(3000) == 0) {
                    System.out.println("等待...");
                    continue;
                }

                Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();

                while (selectionKeyIterator.hasNext()) {
                    SelectionKey selectionKey = selectionKeyIterator.next();
                    // 连接信号，连接客户端，监听该socketChannel的信号
                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        System.out.println(socketChannel.getRemoteAddress() + " 上线！");
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    // 读信号，从channel中取数据
                    else if (selectionKey.isReadable()) {
                        readData(selectionKey);
                    }
                    else
                        System.out.println("收到未知信号!");
                    // 删除当前key
                    selectionKeyIterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取 并 转发
     * @param key
     */
    private void readData(SelectionKey key) {

        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);

            if (count > 0) {
                // 获取数据
                String msg = new String(buffer.array());
                // 服务器端输出消息
                System.out.println("form 客户端：" + msg);
                // 向其它客户端转发信息（排除本身）
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了...");
                // 取消注册
                key.cancel();
                // 关闭通道
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 向其它客户端转发信息（排除本身）
     * @param msg
     * @param self
     * @throws IOException
     */
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中...");

        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();

            // 排除 ServerSocketChannel 和 本身
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                dest.write(ByteBuffer.wrap(msg.getBytes()));
            }
        }
    }

    public static void main(String[] args) {

        // 启动服务器
        Server server = new Server();
        server.listen();
    }
}
