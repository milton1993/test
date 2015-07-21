package com.mitong.test.guava.string;

import com.google.common.base.Charsets;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-20
 */
public class CharsetsTest {
    public static void main(String[] args) {
        byte[] bytes = "fjkdafdaf".getBytes(Charsets.UTF_8);
        for(byte b : bytes) {
            System.out.println(b);
        }
    }
}
