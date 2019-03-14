package com.zouxxyy.multithread.chap3.t7;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {
    protected Object initialValue() {
        return new Date().getTime();
    }
}
