package com.zouxxyy.corejava.volume2.chap04.urlConnection;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * 程序4-6
 * URL测试
 * @version 1.00 2019-03-19
 * @author zouxxyy
 */
public class URLConnectionTest {
    public static void main(String[] args) {
        try{
            String urlName = "https://zouxxyy.github.io";

            URL url = new URL(urlName);
            URLConnection connection = url.openConnection();

            connection.connect();

            System.out.println("开始打印头信息： ");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for(Map.Entry<String, List<String >> entry : headers.entrySet()) {
                String key = entry.getKey();
                for(String value : entry.getValue())
                    System.out.println(key + " : " + value);
            }

            System.out.println("-------------------");
            System.out.println("开始打印网页前10行： ");

            String encoding = connection.getContentEncoding();
            if(encoding == null) encoding = "UTF-8";
            try (Scanner in = new Scanner(connection.getInputStream(), encoding))
            {
                for(int n = 1; in.hasNextLine() && n <= 10; n++)
                    System.out.println(in.nextLine());
                if(in.hasNextLine()) System.out.println("...");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
开始打印头信息：
null : HTTP/1.1 200 OK
X-Cache : HIT
Server : GitHub.com
Access-Control-Allow-Origin : *
Connection : keep-alive
Last-Modified : Thu, 14 Mar 2019 02:59:05 GMT
Date : Tue, 19 Mar 2019 06:52:33 GMT
X-Timer : S1552978354.766200,VS0,VE1
Via : 1.1 varnish
Accept-Ranges : bytes
Strict-Transport-Security : max-age=31556952
Cache-Control : max-age=600
ETag : "5c89c379-d00a"
X-Served-By : cache-lax8637-LAX
Vary : Accept-Encoding
Expires : Tue, 19 Mar 2019 06:56:37 GMT
Content-Length : 53258
X-Cache-Hits : 1
X-Fastly-Request-ID : f310a05ba3f281d7e66bd88f2a0374e149458b76
Age : 356
X-GitHub-Request-Id : F6BC:8CDA:D8BD14:EADB99:5C90904C
Content-Type : text/html; charset=utf-8
-------------------
开始打印网页前10行：
<!DOCTYPE html>






<html class="theme-next pisces use-motion" lang="zh-Hans">
<head><meta name="generator" content="Hexo 3.8.0">
  <meta charset="UTF-8">
...
 */