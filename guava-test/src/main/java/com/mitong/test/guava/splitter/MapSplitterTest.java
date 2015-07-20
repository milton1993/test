package com.mitong.test.guava.splitter;

import com.google.common.base.Splitter;

import java.util.Map;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-20
 */
public class MapSplitterTest {
    public static void main(String[] args) {
        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Splitter.MapSplitter mapSplitter = Splitter.on("#").withKeyValueSeparator("=");
        Map<String, String> stringMap = mapSplitter.split(expectedString);
        System.out.println(stringMap);
    }
}