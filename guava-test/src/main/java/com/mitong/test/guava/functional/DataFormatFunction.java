package com.mitong.test.guava.functional;


import com.google.common.base.Function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-22
 */
public class DataFormatFunction implements Function<Date, String> {
    @Override
    public String apply(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return dateFormat.format(date);
    }
}
