package com.zouxxyy.multithread.chap3.t4;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMetood(PipedOutputStream out) {
        try{
            System.out.println("write: ");
            for(int i = 0; i < 10; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
