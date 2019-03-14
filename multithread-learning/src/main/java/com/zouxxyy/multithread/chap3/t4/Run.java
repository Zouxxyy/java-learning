package com.zouxxyy.multithread.chap3.t4;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 程序3-4
 * 字节流
 * @version 1.00 2019-03-12
 * @author zouxxyy
 */
public class Run {
    public static void main(String[] args) {
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            outputStream.connect(inputStream);

            ThreadRead threadRead = new ThreadRead(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
            threadWrite.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/*
read:
write:
12345678910
12345678910java.io.IOException: Write end dead
	at java.io.PipedInputStream.read(PipedInputStream.java:310)
	at java.io.PipedInputStream.read(PipedInputStream.java:377)
	at java.io.InputStream.read(InputStream.java:101)
	at com.zouxxyy.multithread.chap3.t4.ReadData.readMetood(ReadData.java:15)
	at com.zouxxyy.multithread.chap3.t4.ThreadRead.run(ThreadRead.java:16)
 */
