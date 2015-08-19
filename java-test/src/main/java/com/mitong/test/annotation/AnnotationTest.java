package com.mitong.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/3
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTest {
    String value() default "123";
    String name() default "";
}
