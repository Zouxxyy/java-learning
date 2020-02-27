package com.zouxxyy.nio.buffer;

import java.nio.IntBuffer;

/**
 * buffer 测试
 */

public class BasicBufferTest {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < 2; i++) {
            intBuffer.put(i * 2);
        }

        intBuffer.flip();

        intBuffer.mark();
        intBuffer.get();
        intBuffer.mark();
        intBuffer.get();
        System.out.println(intBuffer);
        System.out.println(intBuffer.reset());
        System.out.println(intBuffer);

//        while (intBuffer.hasRemaining()) {
//            System.out.println(intBuffer.get());
//        }

        intBuffer.mark();
        intBuffer.reset();
        intBuffer.clear();
    }
}
