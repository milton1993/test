package com.mitong.test.guava.string;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-20
 */
public class CharMatcherTest {
    public static void main(String[] args) {

//        CharMatcher.BREAKING_WHITESPACE.replaceFrom();
        Iterable<String> stringIterable = Splitter.on(CharMatcher.DIGIT).omitEmptyStrings().trimResults(CharMatcher.anyOf("afgi")).split("abc12def3322ghi1");
        for(String string : stringIterable) {
            System.out.println(string);
        }
    }
}
