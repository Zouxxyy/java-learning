package com.zouxxyy.effective.chap03.item12;

/**
 * 始终要覆盖toString
 *
 * 这条可不是硬性规定哦～
 */

public final class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }


    // idea 生成的 toString
//    @Override
//    public String toString() {
//        return "PhoneNumber{" +
//                "areaCode=" + areaCode +
//                ", prefix=" + prefix +
//                ", lineNum=" + lineNum +
//                '}';
//    }


    // 书中的
//    @Override public String toString() {
//        return String.format("%03d-%03d-%04d",
//                areaCode, prefix, lineNum);
//    }


    public static void main(String[] args) {

        PhoneNumber jenny = new PhoneNumber(707, 867, 5309);

        System.out.println("Jenny's number: " + jenny);

    }

}

/*
Jenny's number: com.zouxxyy.effective.chap03.item12.PhoneNumber@74a14482


Jenny's number: PhoneNumber{areaCode=707, prefix=867, lineNum=5309}


Jenny's number: 707-867-5309

 */