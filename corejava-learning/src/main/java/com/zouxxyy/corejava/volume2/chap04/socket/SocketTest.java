package com.zouxxyy.corejava.volume2.chap04.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 程序4-1
 * 连接到某端口，并打印找到到信息
 * @version 1.00 2019-03-19
 * @author zouxxyy
 */
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (Socket s = new Socket("time-a.nist.gov", 13); // 构建一个套接字
             Scanner in = new Scanner(s.getInputStream(), "UTF-8"))
        {
            while(in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}

/*
58561 19-03-19 03:38:21 50 0 0 277.4 UTC(NIST) *
 */
