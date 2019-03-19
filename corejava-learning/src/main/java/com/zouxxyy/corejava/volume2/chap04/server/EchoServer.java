package com.zouxxyy.corejava.volume2.chap04.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 程序4-3
 * 实现服务器
 * @version 1.00 2019-03-19
 * @author zouxxyy
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)) { // 建立服务器端口
            try (Socket incoming = s.accept()) { // 等待
                InputStream inStream = incoming.getInputStream(); // 服务器接收。即客服端发出
                OutputStream outStream = incoming.getOutputStream(); // 服务器输出，即客服端接收

                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outStream, "UTF-8"),
                            true);
                    out.println("Hello, enter BYE to exit."); // 给客户端发问候消息
                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}

/* 终端测试：
zxysMac:~ elwg$ telnet localhost 8189
Trying ::1...
Connected to localhost.
Escape character is '^]'.
Hello, enter BYE to exit.
hello
Echo: hello
BYE
Echo: BYE
Connection closed by foreign host.
 */
