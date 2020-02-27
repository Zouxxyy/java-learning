package com.zouxxyy.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO 测试
 */

public class BIOServer {
    public static void main(String[] args) throws IOException {

        // 线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 服务端 socket
        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");

        while (true) {
            System.out.println("服务端等待连接...");

            // 连接到一个客户端（阻塞）
            final Socket socket = serverSocket.accept();

            System.out.println("连接到一个新的客户端！");

            // 创建一个线程，打印收到的信息
            executorService.execute(() -> handler(socket));
        }
    }

    public static void handler(Socket socket) {

        // 通过socket获取输入流
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            int count;
            while (true) {
                count = inputStream.read(bytes);
                System.out.println(Thread.currentThread().getName() + "线程正在 reading..."); //（阻塞）
                System.out.println(new String(bytes, 0, count));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
