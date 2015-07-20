package com.mitong.test.guava.joiner;

import com.google.common.base.Joiner;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-19
 */
public class JoinerOfArray {
    public static void main(String[] args) {
        String[] ss = new String[]{"123","23",null};
        System.out.println(Joiner.on("|").skipNulls().join(ss));
        System.out.println(Joiner.on("|").useForNull("123").join(ss));
    }
}
