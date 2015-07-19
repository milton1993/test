package com.mitong.test.guava;

import com.google.common.base.Optional;

import javax.swing.text.html.Option;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Integer> optional1 = Optional.of(5);
        System.out.println(optional1.isPresent());
        System.out.println(optional1.get());
        System.out.println(optional1.or(3));
        System.out.println(optional1.orNull());
        System.out.println(optional1.asSet());
        Integer integer = null;
//        Optional<Integer> optional2 = Optional.of(integer); //NullPointerException
        Optional<Integer> optional3 = Optional.absent();
        System.out.println(optional3.isPresent());
//        System.out.println(optional3.get()); //get() cannot be called on an absent value
        System.out.println(optional3.or(3));
        System.out.println(optional3.orNull());
        System.out.println(optional3.asSet());
        Optional<Integer> optional4 = Optional.fromNullable(integer);
        System.out.println(optional4.isPresent());
//        System.out.println(optional4.get()); //get() cannot be called on an absent value
        System.out.println(optional4.or(3));
        System.out.println(optional4.orNull());
        System.out.println(optional4.asSet());
        integer = 5;
        Optional<Integer> optional5 = Optional.fromNullable(integer);
        System.out.println(optional5.isPresent());
        System.out.println(optional5.get());
        System.out.println(optional5.or(3));
        System.out.println(optional5.orNull());
        System.out.println(optional5.asSet());
    }
}
