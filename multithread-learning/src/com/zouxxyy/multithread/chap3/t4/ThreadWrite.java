package com.zouxxyy.multithread.chap3.t4;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedOutputStream out;

    public ThreadWrite(WriteData writeData, PipedOutputStream out) {
        super();
        this.writeData = writeData;
        this.out = out;
    }

    public void run() {
        writeData.writeMetood(out);
    }
}