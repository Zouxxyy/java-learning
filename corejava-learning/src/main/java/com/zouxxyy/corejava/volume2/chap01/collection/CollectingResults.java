package com.zouxxyy.corejava.volume2.chap01.collection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 程序1-4
 * 从流中收集元素
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class CollectingResults {
    // 删除元音字母
    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("corejava-learning/src/main/resources/chap01_test.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.println("["
            + set.stream().limit(10).map(Objects::toString)
                .collect(Collectors.joining(", ")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array:" + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("numbers: " + number);
            System.out.println("接下来会发生异常：");
            Integer[] numbers2 = (Integer[]) numbers;
        }
        catch (ClassCastException ex) {
            System.out.println(ex);
        }

        Integer[] numbers3 = Stream.iterate(0, n -> n +1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array:" + numbers3);

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining : " + result);
        result = noVowels().limit(10).collect(Collectors.joining(", "));
        System.out.println("Joining with commas: " + result);

        IntSummaryStatistics summary = noVowels().collect(
                Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("forEach:");
        noVowels().limit(10).forEach(System.out::println);
    }
}

/*
0
1
2
3
4
5
6
7
8
9
Object array:[Ljava.lang.Object;@34c45dca
numbers: 0
接下来会发生异常：
java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
Integer array:[Ljava.lang.Integer;@312b1dae
noVowelSet: java.util.HashSet[, Frm, bckyrd, css, pr, spclly, hm, hs, hv, HV]
noVowelTreeSet: java.util.TreeSet[, DS, Frm, H, HV, Lt, Mdctns, Sh, Th, Ths]
Joining : nmydlprfssnsndctrndhlthcr
Joining with commas: n, my, dl, prfssn, s, n, dctr, nd, hlth, cr
Average word length: 2.7223880597014927
Max word length: 8.0
forEach:
n
my
dl
prfssn
s
n
dctr
nd
hlth
cr
 */