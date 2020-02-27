package com.zouxxyy.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * SocketChannel 和多个buffer 测试
 */

public class SocketChannelTest {
    public static void main(String[] args) throws IOException {

        // 服务器端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7000));

        // buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        System.out.println("服务端等待连接...");
        SocketChannel socketChannel = serverSocketChannel.accept();
        long count;
        while (true) {
            count = socketChannel.read(byteBuffers);
            System.out.println("从socketChannel读入: " + count);

            for (ByteBuffer byteBuffer : byteBuffers) {
                System.out.print(byteBuffer);
                System.out.println(" 内容为: " + new String(byteBuffer.array()));
                byteBuffer.clear(); // 注意clear并没有清除数据
            }
        }
    }
}

/*
服务端等待连接...
从socketChannel读入: 8
java.nio.HeapByteBuffer[pos=5 lim=5 cap=5] 内容为: 12345
java.nio.HeapByteBuffer[pos=3 lim=3 cap=3] 内容为: 678
 */