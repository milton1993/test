package com.mitong.test.guava.joiner;

import com.google.common.base.Joiner;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-19
 */
public class JoinerOfVarargs {
    public static void main(String[] args) {
        Joiner stringJoiner = Joiner.on("|").skipNulls();
        try {
            //cannot concatenate varargs containing null when using either useForAll or skipNulls
            //because Preconditions.checkNotNull method is called during the appendTo method is called.
            System.out.println(Joiner.on("|").useForNull("no value").join("foo", "bar", null));
            System.out.println(stringJoiner.join("foo", "bar", null));


            //the useForNull() method returns a new instance of the Joiner!
            //why throws an UnsupportedOperationException
            stringJoiner.useForNull("missing");
            System.out.println(stringJoiner.join("foo","bar",null));
        } catch (Exception e) {

        }
    }
}
