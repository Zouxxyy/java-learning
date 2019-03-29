package com.zouxxyy.jvm.chap4;

import java.util.Scanner;

/**
 * 程序4-1
 * jps测试
 * @version 1.00 2019-03-23
 * @author zouxxyy
 */
public class JpsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

/*
(base) zxysMac:~ elwg$ jps -l
16387 org.jetbrains.idea.maven.server.RemoteMavenServer
44422 sun.tools.jps.Jps
44392 com.zouxxyy.jvm.chap4.JpsTest
31368 org.jetbrains.kotlin.daemon.KotlinCompileDaemon
16217
44393 org.jetbrains.jps.cmdline.Launcher
 */