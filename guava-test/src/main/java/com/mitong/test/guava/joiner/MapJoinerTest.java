package com.mitong.test.guava.joiner;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-19
 */
public class MapJoinerTest {
    public static void main(String[] args) {
        String expectedString = "Washington D.C=Redskins#New York City=Giants#Philadelphia=Eagles#Dallas=Cowboys";
        Map<String,String> testMap = Maps.newLinkedHashMap();
        testMap.put("Washington D.C","Redskins");
        testMap.put("New York City","Giants");
        testMap.put("Philadelphia","Eagles");
        testMap.put("Dallas","Cowboys");
        String returnedString = Joiner.on("#").
                withKeyValueSeparator("=").join(testMap);
        System.out.println(returnedString.equals(expectedString));
    }
}
