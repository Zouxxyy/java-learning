package com.zouxxyy.corejava.volume2.chap01.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 程序1-1
 * 使用流对列表进行操作
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("corejava-learning/src/main/resources/chap01_test.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+")); // 按非字母分割，或得单词列表

        long count = 0;
        for(String w : words) {
            if (w.length() > 12) {
                count++;
                System.out.println(w);
            }
        }
        System.out.println(count);

        // 集合的stream方法将集合变成流
        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        // 并行流
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}

/*
relationships
unfortunately
2
2
2
 */