package com.zouxxyy.nio.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 传统IO服务器
 */

public class OldIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7001);

        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        byte[] bytes = new byte[3];

        int count;
        long total = 0;
        while ((count = dataInputStream.read(bytes)) != -1) {
            // System.out.println(new String(bytes, 0, count));
            total += count;
        }

        System.out.println("接收完毕" + "总字节数：" + total);
        dataInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
