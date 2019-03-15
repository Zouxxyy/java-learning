package com.zouxxyy.corejava.volume2.chap01.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;

/**
 * 程序1-7
 * 基本类型流的API示例
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class PrimitiveTypeStreams {
    public static void show(String title, IntStream stream) {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title  +": ");
        for(int i = 0; i < firstElements.length; i++) {
            if(i > 0) System.out.print(", ");
            if(i < SIZE) System.out.print(firstElements[i]);
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", is1);
        IntStream is2 = IntStream.range(5, 10);
        show("is2", is2);
        IntStream is3 = IntStream.rangeClosed(5, 10);
        show("is3", is3);

        Path path = Paths.get("corejava-learning/src/main/resources/chap01_test.txt");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        // 静态方法创建流
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        IntStream is4 = words.mapToInt(String::length);
        show("is4:", is4);

        String sentence = "\uD835\uDD46 is the set of octonions."; // UTF-16
        System.out.println(sentence);
        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c -> String.format("%X ", c)).collect(Collectors.joining()));

        // 基本类型流与对象流的转换
        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream is5 = integers.mapToInt(Integer::intValue);
        show("is5", is5);
    }
}

/*
is1: 70, 31, 82, 99, 56, 65, 15, 6, 33, 90, ...
is2: 5, 6, 7, 8, 9
is3: 5, 6, 7, 8, 9, 10
is4:: 2, 2, 4, 10, 2, 2, 8, 3, 6, 4, ...
𝕆 is the set of octonions.
1D546 20 69 73 20 74 68 65 20 73 65 74 20 6F 66 20 6F 63 74 6F 6E 69 6F 6E 73 2E
is5: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, ...
 */