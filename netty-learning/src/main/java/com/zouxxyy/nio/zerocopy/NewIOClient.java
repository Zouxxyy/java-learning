package com.zouxxyy.nio.zerocopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * NIO 客户端
 */

public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 7001));

        FileChannel fileChannel = new FileInputStream("data/output/channelTest1.txt").getChannel();

        long transferCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

        while ((transferCount = fileChannel.transferTo(total, fileChannel.size(), socketChannel)) != 0) {
            total += transferCount;
        }

        long endTime = System.currentTimeMillis();

        System.out.println("总字节数：" + total + "，耗时：" + (endTime - startTime) + "ms");
    }
}

/*
总字节数：2639076，耗时：47ms
总字节数：134761300，耗时：2496ms
 */