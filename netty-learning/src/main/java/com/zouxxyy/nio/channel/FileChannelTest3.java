package com.zouxxyy.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * channel 连接
 * 方式1：文件 -> channel -> buffer -> channel -> 文件
 * 方式2：文件 -> channel -> transform -> channel -> 文件
 */

public class FileChannelTest3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("data/output/channelTest1.txt");
        FileChannel channel01 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("data/output/channelTest2.txt");
        FileChannel channel02 = fileOutputStream.getChannel();

        // 方式1
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        // 放数据到buffer -> flip -> 从buffer取数据 -> clear
        while (channel01.read(byteBuffer) != -1) {

            byteBuffer.flip();

            channel02.write(byteBuffer);

            byteBuffer.clear();
        }

        // 方式2
        // channel02.transferFrom(channel01, 0, channel01.size());

        fileInputStream.close();
        fileOutputStream.close();
    }
}
