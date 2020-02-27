package com.zouxxyy.nio.channel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 写入本地文件
 * 字符串 -> buffer -> channel -> 文件
 */

public class FileChannelTest1 {
    public static void main(String[] args) throws IOException {

        String str = "hello, zxy";

        // 1. 创建一个OutputStream
        FileOutputStream fileOutputStream = new FileOutputStream("data/output/channelTest1.txt");

        // 2. 生成channel
        FileChannel channel = fileOutputStream.getChannel();

        // 3. 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 4. 数据 -> buffer
        byteBuffer.put(str.getBytes());

        // 5. buffer flip (写 -> 读)
        byteBuffer.flip();

        // 6. buffer -> channel
        channel.write(byteBuffer);

        fileOutputStream.close();
    }
}
