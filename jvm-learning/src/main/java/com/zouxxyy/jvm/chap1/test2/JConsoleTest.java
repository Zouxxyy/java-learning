package com.zouxxyy.jvm.chap1.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序1-2
 * JConsole调试工具初探
 * @version 1.00 2019-03-20
 * @author zouxxyy
 */
public class JConsoleTest {
    public static void main(String[] args) {
        fill(1000);
    }


    private static void fill(int n) {
        List<JConsoleTest> jlist = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            jlist.add(new JConsoleTest());
        }
    }
}
