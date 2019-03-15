package com.zouxxyy.corejava.volume2.chap01.streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 程序1-2
 * 创建流的各种方式
 * @version 1.00 2019-03-15
 * @author zouxxyy
 */
public class CreatingStreams {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream
                .limit(SIZE + 1)
                .collect(Collectors.toList());
        System.out.print(title + ": ");
        for(int i = 0; i < firstElements.size(); i++) {
            if(i > 0) System.out.print(", ");
            if(i < SIZE) System.out.print(firstElements.get(i));
            else System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("corejava-learning/src/main/resources/chap01_test.txt");
        String contents = new String(Files.readAllBytes(path),
                StandardCharsets.UTF_8);

        // 静态方法创建流
        Stream<String> words = Stream.of(contents.split("\\PL+"));
        show("words", words);

        Stream<String> song = Stream.of("gently", "cat", "dog", "apple");
        show("song", song);

        // 创建不含任何元素的流
        Stream<String> silence = Stream.empty();
        show("silence", silence);

        // generator创建无限流
        Stream<String> echos = Stream.generate(() -> "Echo");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("randoms", randoms);

        // iterate方法创建无限流
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE,
                n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay = Pattern.compile("\\PL+").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        }
    }
}

/*
words: In, my, dual, profession, as, an, educator, and, health, care, ...
song: gently, cat, dog, apple
silence:
echos: Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, Echo, ...
randoms: 0.912662849372204, 0.030592695112787616, 0.9811983982795396, 0.7986000931652628, 0.7227114973846251, 0.22739002716070367, 0.3106631864731271, 0.0856356647765314, 0.6447995489692386, 0.9353209445966172, ...
integers: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ...
wordsAnotherWay: In, my, dual, profession, as, an, educator, and, health, care, ...
lines: In my dual profession as an educator and health care provider, I have worked with numerous children infected with the virus that causes AIDS. The relationships that I have had with these special kids have been gifts in my life. They have taught me so many things, but I have especially learned that great courage can be found in the smallest of packages. Let me tell you about Tyler., , Tyler was born infected with HIV: his mother was also infected. From the very beginning of his life, he was dependent on medications to enable him to survive. When he was five, he had a tube surgically inserted in a vein in his chest. This tube was connected to a pump, which he carried in a small backpack on his back. Medications were hooked up to this pump and were continuously supplied through this tube to his bloodstream. At times, he also needed supplemented oxygen to support his breathing., , Tyler wasn’t willing to give up one single moment of his childhood to this deadly disease. It was not unusual to find him playing and racing around his backyard, wearing his medicine-laden backpack and dragging his tank of oxygen behind him in his little wagon. All of us who knew Tyler marveled at his pure joy in being alive and the energy it gave him. Tyler’s mom often teased him by telling him that he moved so fast she needed to dress him in red. That way, when she peered through the window to check on him playing in the yard, she could quickly spot him., , This dreaded disease eventually wore down even the likes of a little dynamo like Tyler. He grew quite ill and, unfortunately, so did his HIV-infected mother. When it became apparent that he wasn’t going to survive, Tyler’s mom talked to him about death. She comforted him by telling Tyler that she was dying too, and that she would be with him soon in heaven.
 */
