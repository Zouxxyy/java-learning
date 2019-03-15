package com.zouxxyy.corejava.volume2.chap01.optional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 程序1-3
 * Optional API 的使用方方式
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class OptionalTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("corejava-learning/src/main/resources/chap01_test.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        // findFirst()返回Optional的对象
        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");


        // Optional为空时的操作
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);
        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        }
        catch (Throwable t) {
            t.printStackTrace();
        }

        // ifPresent测试
        optionalValue = wordList.stream()
                .filter(s -> s.contains("blood"))
                .findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains blood"));

        // map测试
        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add); // results里已有，所里这里是false
        System.out.println(added);

        // flapmap
        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(-0.4)
                .flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}

/*
myfreddsda contains fred
result: N/A
result: 中文 (中国)
java.lang.IllegalStateException
	at java.util.Optional.orElseThrow(Optional.java:290)
	at com.zouxxyy.corejava.volume2.chap01.optional.OptionalTest.main(OptionalTest.java:35)
bloodstream contains blood
Optional[false]
Optional[0.5]
Optional.empty
Optional.empty
Optional.empty
 */