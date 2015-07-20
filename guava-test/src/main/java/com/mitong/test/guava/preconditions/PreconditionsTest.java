package com.mitong.test.guava.preconditions;

import com.google.common.base.Preconditions;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        System.out.println(args);
        String[] arg = Preconditions.checkNotNull(args);
        System.out.println(arg);
        Preconditions.checkState(true);
    }
}
