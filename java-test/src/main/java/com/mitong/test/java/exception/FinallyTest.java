package com.mitong.test.java.exception;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-24
 */
public class FinallyTest {
    public static int test() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
