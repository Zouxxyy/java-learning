package com.zouxxyy.nio.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 服务端
 */

public class NewIOServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7001));

        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(3);

        int count;
        long total = 0;
        try {
            while ((count = socketChannel.read(buffer)) != -1) {
//                buffer.flip();
//                while(buffer.hasRemaining()){
//                    System.out.print((char) buffer.get());
//                }
//                System.out.println();
                buffer.clear();
                total += count;
            }
        } catch (IOException ignored) {
            System.out.println("连接关闭");
        }

        System.out.println("接收完毕" + "总字节数：" + total);
        socketChannel.close();
        serverSocketChannel.close();
    }
}
