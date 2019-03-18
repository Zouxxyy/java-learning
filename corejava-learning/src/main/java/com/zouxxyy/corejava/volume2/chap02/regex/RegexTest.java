package com.zouxxyy.corejava.volume2.chap02.regex;

import java.util.*;
import java.util.regex.*;

/**
 * 程序2-6
 * 正则表达式匹配，并打印群组边界
 * @version 1.00 2019-03-18
 * @author zouxxyy
 */
public class RegexTest {
    public static void main(String[] args) throws PatternSyntaxException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter pattern: ");
        String patternString = in.nextLine(); // 输入一个模式

        Pattern pattern = Pattern.compile(patternString);

        while (true) {
            System.out.println("Enter string to match: ");
            String input = in.nextLine();
            if(input == null || input.equals("")) return;
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()) {
                System.out.println("Match");
                int g = matcher.groupCount();
                if(g > 0) {
                    for(int i = 0; i < input.length(); i++) {
                        for(int j = 1; j <= g; j++)
                            if(i == matcher.start(j) && i == matcher.end(j))
                                System.out.print("()");

                        for(int j = 1; j <= g; j++)
                            if(i == matcher.start(j) && i != matcher.end(j))
                                System.out.print("(");

                        System.out.print(input.charAt(i));

                        for(int j = 1; j <= g; j++)
                            if(i + 1 != matcher.start(j) && i + 1 == matcher.end(j))
                                System.out.print(")");
                    }
                    System.out.println();
                }
            }
            else
                System.out.println("No match");
        }
    }
}

/*
Enter pattern:
(([1-9]|1[0-2]):([0-5][0-9]))[ap]m
Enter string to match:
13:30am
No match
Enter string to match:
11:59am
Match
((11):(59))am

 */