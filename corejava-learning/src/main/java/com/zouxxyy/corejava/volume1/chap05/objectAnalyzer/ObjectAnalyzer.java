package com.zouxxyy.corejava.volume1.chap05.objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 程序5-15
 * toString()函数
 * @version 1.00 2019-03-02
 * @author zouxxyy
 */
public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj) {
        if(obj == null) return "null";
        if(visited.contains(obj)) return "...";
        visited.add(obj); // 防止出现无限递归
        Class cl = obj.getClass();
        if(cl == String.class) return (String) obj; // obj是字符串直接输出
        //处理数组
        if(cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for(int i = 0; i < Array.getLength(obj); i++) {
                if(i > 0) r += ",";
                Object val = Array.get(obj, i);
                if(cl.getComponentType().isPrimitive()) r += val; // 判断是不是基本类型
                else r += toString(val); //对数组内的对象递归调用toString
            }
            return r + "}";
        }
        //处理对象
        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true); //将域设置为可访问
            //只打印非静态域
            for(Field f: fields) {
                if(!Modifier.isStatic(f.getModifiers())) {
                    if(!r.endsWith("[")) r += ",";
                    r += f.getName() + "="; //打印域名
                    //打印值
                    try{
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if(t.isPrimitive()) r += val; //判断是不是基本类型
                        else r += toString(val); //不是基本类型就调用toString
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass(); //查看超类的域
        }
        while (cl != null); //至此查看完毕全部的域
        return r;
    }
}
