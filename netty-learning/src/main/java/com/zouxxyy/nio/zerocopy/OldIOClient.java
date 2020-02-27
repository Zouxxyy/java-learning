package com.zouxxyy.nio.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 传统IO客户端
 */

public class OldIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 7001);

        FileInputStream fileInputStream = new FileInputStream("data/output/channelTest1.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[4096];
        long readCount;
        long total = 0;

        long startTime = System.currentTimeMillis();

         while ((readCount = fileInputStream.read(bytes)) >= 0){
            total += readCount;
            dataOutputStream.write(bytes, 0, (int) readCount);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("总字节数：" + total + "，耗时：" + (endTime - startTime) + "ms");
        dataOutputStream.close();
        socket.close();
        fileInputStream.close();
    }
}

/*
总字节数：2639076，耗时：62ms
总字节数：134761299，耗时：3073ms
 */