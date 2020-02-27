package com.zouxxyy.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 读取本地文件
 * 字符串 <- buffer <- channel <- 文件
 */

public class FileChannelTest2 {
    public static void main(String[] args) throws IOException {

        File file = new File("data/output/channelTest1.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());

        channel.read(buffer);

        System.out.println(new String(buffer.array()));

        fileInputStream.close();
    }
}
