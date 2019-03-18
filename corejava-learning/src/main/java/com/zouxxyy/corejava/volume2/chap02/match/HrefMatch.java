package com.zouxxyy.corejava.volume2.chap02.match;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

/**
 * 程序2-7
 * 定位Web页面的超文本引用
 * @version 1.00 2019-03-18
 * @author zouxxyy
 */
public class HrefMatch {
    public static void main(String[] args) {
        try {
            String urlString = "https://zouxxyy.github.io";

            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream(), StandardCharsets.UTF_8);

            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1)
                input.append((char) ch);

            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            // find可以找匹配的子字符串
            while (matcher.find()) {
                String match = matcher.group();
                System.out.println(match);
            }
        }
        catch (IOException | PatternSyntaxException e)
        {
            e.printStackTrace();
        }
    }
}

/*
<a href="/archives/">
<a href="/categories/index.html">
<a href="/tags/index.html">
 */
