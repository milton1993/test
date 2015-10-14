package com.mitong.test.java.exception;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/11
 */
public class Test {
    public int add(int a, int b) {
        try {
            return a+b;
        } catch (Exception e) {
            System.out.println("abc");
        } finally {
            System.out.println("123");
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("123" + new Test().add(1,2));
    }
}
