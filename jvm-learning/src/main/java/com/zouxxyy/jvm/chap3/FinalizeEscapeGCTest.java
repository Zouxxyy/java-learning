package com.zouxxyy.jvm.chap3;

/**
 * 程序3-2
 * 对象只能自我拯救一次
 * @version 1.00 2019-03-22
 * @author zouxxyy
 */
public class FinalizeEscapeGCTest {
    public static FinalizeEscapeGCTest SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("我还活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法 执行");
        FinalizeEscapeGCTest.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGCTest();

        // 第一次拯救
        SAVE_HOOK = null;
        System.gc();

        //finalize优先级低所以暂停一会
        Thread.sleep(500);

        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }
        else System.out.println("我GG了");

        // 第二次拯救
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if(SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }
        else System.out.println("我GG了");
    }
}

/*
finalize 方法 执行
我还活着
我GG了
 */