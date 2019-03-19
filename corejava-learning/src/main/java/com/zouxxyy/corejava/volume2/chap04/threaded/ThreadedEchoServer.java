package com.zouxxyy.corejava.volume2.chap04.threaded;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 程序4-4
 * 为多个客户端提供服务
 * @version 1.00 2019-03-19
 * @author zouxxyy
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(8189)) {
            int i = 1;

            while (true) {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadEchoHandle(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadEchoHandle implements Runnable {
    private Socket incoming;

    public ThreadEchoHandle(Socket incoming) {
        this.incoming = incoming;
    }

    public void run() {
        try (InputStream inStream = incoming.getInputStream();
             OutputStream outStream = incoming.getOutputStream()) {
            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(outStream, "UTF-8"),
                    true);
            out.println("Hello, enter BYE to exit.");
            boolean done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) done = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Spawning 1
Spawning 2
 */