package com.zouxxyy.corejava.volume2.chap04.inetAddress;

import java.io.IOException;
import java.net.InetAddress;

/**
 * 程序4-2
 * 打印某主机的全部网络地址
 * @version 1.00 2019-03-19
 * @author zouxxyy
 */
public class InetAddtessTest {
    public static void main(String[] args) throws IOException {
        String host = "zouxxyy.github.io";
        InetAddress[] addresses = InetAddress.getAllByName(host);
        for(InetAddress a : addresses)
            System.out.println(a);
    }
}

/*
zouxxyy.github.io/185.199.111.153
zouxxyy.github.io/185.199.109.153
zouxxyy.github.io/185.199.110.153
zouxxyy.github.io/185.199.108.153
 */
