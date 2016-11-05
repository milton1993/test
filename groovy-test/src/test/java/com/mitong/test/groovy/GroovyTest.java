package com.mitong.test.groovy;

import org.junit.Before;
import org.junit.Test;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description
 */
public class GroovyTest {
    Classes classes = new Classes();

    @Before
    public void before() {
        classes.setField1("field1");
        classes.setField2("field2");
        classes.setField3("field3");
        classes.setField4("field4");
        classes.setField5("field5");
    }

    @Test
    public void test() {
        System.out.println(classes);
    }
}
