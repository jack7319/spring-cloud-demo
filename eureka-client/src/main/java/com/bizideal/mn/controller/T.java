package com.bizideal.mn.controller;

/**
 * @author : liulq
 * @date: 创建时间: 2018/3/12 14:41
 * @version: 1.0
 * @Description:
 */
public class T {

    static Integer a = 1;    // 这里会发生 Integer.valueOf(1);
    static Integer b = 1;
    static Integer c = 1111;
    static Integer d = 1111;
    static int i = a;  // 这里会发生 a.intValue();

    public static void main(String[] args) {
        System.out.println(a == b); // true Integer类中会缓存一个Integer对象数组，范围从-128 - +127
        System.out.println(a == i); // true
        System.out.println(i == a); // true
        System.out.println(c == d); // false c和d会分别new Integer(1111); 地址当然不同
    }
}
