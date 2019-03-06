package com.zouxxyy.corejava.chap9.set;

import java.util.*;

/**
 * 程序9-2
 * hashset使用示例
 * @version 1.00 2019-03-06
 * @author zouxxyy
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> words= new HashSet<>();
        long totalTime = 0; // 计算单词添加到set的总时间

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String word = in.next();
            if(word.equals("exit")) break;
            long callTime = System.currentTimeMillis();
            words.add(word);
            callTime = System.currentTimeMillis() - callTime;
            totalTime += callTime;
        }

        Iterator<String> iter = words.iterator();
        for(int i = 0; i <= 20 && iter.hasNext(); i++)
            System.out.println(iter.next());
        System.out.println("...");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
        System.out.println(words.contains("cat"));
    }
}

/*输出：
cat
dog
apple
fish
pig
pen
exit
apple
cat
fish
pen
dog
pig
...
6 distinct words. 0 milliseconds.
true
 */