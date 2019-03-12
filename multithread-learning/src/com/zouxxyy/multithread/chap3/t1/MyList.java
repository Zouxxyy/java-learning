package com.zouxxyy.multithread.chap3.t1;

import java.util.ArrayList;
import java.util.List;

public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("zxy");
    }

    public static int size() {
        return list.size();
    }
}
