package com.zouxxyy.corejava.chap5.objectAnalyzer;

import java.util.ArrayList;

/**
 * 程序5-14
 * toString()函数
 * @version 1.00 2019-03-02
 * @author zouxxyy
 */
public class ObjectAnalyzerTest {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i <= 5; i++)
            squares.add(i * i);
        Integer integer = 1;

        //对Integer测试
        System.out.println(new ObjectAnalyzer().toString(integer));
        /*输出：java.lang.Integer[value=1][][]
        * 解释：
        * Interger 只有一个非静态域：private final int value;，直接打印[value=1].
        * 可以看出后面还有有两个[],说明它有超类Number和Number的超类Object
        * 但[]里是空的，说明它们的非静态域是空的
        * */

        //对ArrayList测试
        System.out.println(new ObjectAnalyzer().toString(squares));
    }
}

/*输出：
java.lang.Integer[value=1][][]
java.util.ArrayList[elementData=class java.lang.Object[]{java.lang.Integer[value=1][][],java.lang.Integer[value=4][][],java.lang.Integer[value=9][][],java.lang.Integer[value=16][][],java.lang.Integer[value=25][][],null,null,null,null,null},size=5][modCount=5][][]
 */
