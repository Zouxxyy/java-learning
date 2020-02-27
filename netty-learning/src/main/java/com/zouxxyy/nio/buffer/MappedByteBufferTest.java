package com.zouxxyy.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 测试
 */

public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("data/output/channelTest1.txt", "rw");

        FileChannel channel = file.getChannel();

        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(1, (byte) 'H');

        file.close();
        System.out.println("修改成功");

        // 注意IDEA中看还没有修改！但是通过文件系统看已经修改了，神奇
    }
}
