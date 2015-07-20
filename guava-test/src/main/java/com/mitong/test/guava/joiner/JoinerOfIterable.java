package com.mitong.test.guava.joiner;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-19
 */
public class JoinerOfIterable {
    public static void main(String[] args) {
        //if using an ArrayList as the argument, the join method will skip null values;
        //but if using the varargs as before, the join method will throw an NullPointerException
        //even though the skipNulls method is called.
        List<String> stringList = new ArrayList<String>();
        stringList.add("123");
        stringList.add("456");
        stringList.add(null);
        System.out.println(Joiner.on("|").skipNulls().join(stringList));
        System.out.println(Joiner.on("|").useForNull("no value").join(stringList));
    }
}
