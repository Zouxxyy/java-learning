package com.zouxxyy.corejava.chap5.reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * 程序5-13
 * 用反射查看一个类的全部信息
 * @version 1.00 2019-03-02
 * @author zouxxyy
 */
public class ReflectionTest
{
    public static void main(String[] args) {

        String name = "java.lang.Integer"; //可以自己选择想看的类

        try{
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers()); // 获取c1的修饰符，如 public 、static 等
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if(supercl != null && supercl != Object.class)
                System.out.print(" extends " + supercl.getName()); // 至此第一行获取完毕

            System.out.print("\n{\n");
            printConstructors(cl); // 打印构造器
            System.out.println();
            printMethods(cl); // 打印方法
            System.out.println();
            printFields(cl); // 打印域
            System.out.println("}");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * 打印类的构造器
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for(Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");
            //打印参数
            Class[] paramTypes = c.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的方法
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();

        for(Method m : methods) {
            Class retType = m.getReturnType(); //方法中多了返回类型
            String name = m.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            //打印参数
            Class[] paramTypes = m.getParameterTypes();
            for(int j = 0; j < paramTypes.length; j++) {
                if(j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * 打印类的域
     * @param cl a class
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();

        for(Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}

/*输出：
public final class java.lang.Integer extends java.lang.Number
{
  public java.lang.Integer(int);
  public java.lang.Integer(java.lang.String);

  public static int numberOfLeadingZeros(int);
  public static int numberOfTrailingZeros(int);
  public static int bitCount(int);
  public boolean equals(java.lang.Object);
  public static java.lang.String toString(int, int);
  public java.lang.String toString();
  public static java.lang.String toString(int);
  public static int hashCode(int);
  public int hashCode();
  public static int min(int, int);
  public static int max(int, int);
  public static int reverseBytes(int);
  public int compareTo(java.lang.Integer);
  public volatile int compareTo(java.lang.Object);
  public byte byteValue();
  public short shortValue();
  public int intValue();
  public long longValue();
  public float floatValue();
  public double doubleValue();
  public static java.lang.Integer valueOf(int);
  public static java.lang.Integer valueOf(java.lang.String);
  public static java.lang.Integer valueOf(java.lang.String, int);
  public static java.lang.String toHexString(int);
  static void getChars(int, int, [C);
  public static java.lang.Integer decode(java.lang.String);
  public static int compare(int, int);
  public static int reverse(int);
  static int stringSize(int);
  public static int sum(int, int);
  public static long toUnsignedLong(int);
  public static int parseInt(java.lang.String);
  public static int parseInt(java.lang.String, int);
  public static java.lang.String toUnsignedString(int);
  public static java.lang.String toUnsignedString(int, int);
  public static java.lang.String toOctalString(int);
  public static java.lang.String toBinaryString(int);
  private static java.lang.String toUnsignedString0(int, int);
  static int formatUnsignedInt(int, int, [C, int, int);
  public static int parseUnsignedInt(java.lang.String);
  public static int parseUnsignedInt(java.lang.String, int);
  public static java.lang.Integer getInteger(java.lang.String, int);
  public static java.lang.Integer getInteger(java.lang.String);
  public static java.lang.Integer getInteger(java.lang.String, java.lang.Integer);
  public static int compareUnsigned(int, int);
  public static int divideUnsigned(int, int);
  public static int remainderUnsigned(int, int);
  public static int highestOneBit(int);
  public static int lowestOneBit(int);
  public static int rotateLeft(int, int);
  public static int rotateRight(int, int);
  public static int signum(int);

  public static final int MIN_VALUE;
  public static final int MAX_VALUE;
  public static final java.lang.Class TYPE;
  static final [C digits;
  static final [C DigitTens;
  static final [C DigitOnes;
  static final [I sizeTable;
  private final int value;
  public static final int SIZE;
  public static final int BYTES;
  private static final long serialVersionUID;
}

*/