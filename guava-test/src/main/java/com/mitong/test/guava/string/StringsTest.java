package com.mitong.test.guava.string;

import com.google.common.base.Strings;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-20
 */
public class StringsTest {
    public static void main(String[] args) {
        String temp = "123456";
        String temp1 = Strings.padEnd(temp,8,'a');
        System.out.println(temp);
        System.out.println(temp1);

//        temp = null;
        temp1 = Strings.nullToEmpty(temp);
        System.out.println(temp);
        System.out.println(temp1);
        System.out.println(temp.equals(temp1));
    }
}
