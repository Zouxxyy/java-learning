package com.zouxxyy.corejava.volume2.chap01.parallel;

import static java.util.stream.Collectors.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.stream.*;
import java.util.*;

/**
 * 程序1-8
 * 并行流
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class ParallelStreams {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("corejava-learning/src/main/resources/chap01_test.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        // 错误示例
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s ->
        {
            if(s.length() < 10) shortWords[s.length()]++;
        });
        System.out.println(Arrays.toString(shortWords));

        // 分组再计算
        Map<Integer, Long> shortWordsCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(groupingBy(String::length, counting()));
        System.out.println(shortWordsCounts);

        Map<Integer, List<String>> result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(10));

        // 使用独立于排序的下游收集器
        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
                groupingByConcurrent(String::length, counting()));
        System.out.println(wordCounts);

    }
}

/*
[0, 12, 62, 73, 66, 34, 29, 20, 19, 6]
{1=12, 2=62, 3=73, 4=68, 5=34, 6=29, 7=20, 8=19, 9=6}
[myfreddsda, eventually, especially, profession, surgically]
{1=12, 2=62, 3=73, 4=68, 5=34, 6=29, 7=20, 8=19, 9=6, 10=5, 11=3, 12=2, 13=2}
 */
