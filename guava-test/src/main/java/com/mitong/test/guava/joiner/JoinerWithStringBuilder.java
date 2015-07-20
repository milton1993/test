package com.mitong.test.guava.joiner;

import com.google.common.base.Joiner;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-19
 */
public class JoinerWithStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        Joiner joiner = Joiner.on("|").skipNulls();
        //returns the StringBuilder instance with the values foo,bar,baz appeneded with "|" delimiters
        stringBuilder = joiner.appendTo(stringBuilder,"foo","bar","baz",null);
        System.out.println(stringBuilder.toString());
    }
}
