package com.mitong.test.guava.splitter;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.regex.Pattern;


/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-20
 */
public class SplitterBasics {
    public static void main(String[] args) {
        Iterable<String> splitStrings = Splitter.on("|").split("123|456|789");
        for(String singleString : splitStrings) {
            System.out.println(singleString);
        }


        //why cannot split string use the "\\d+"
        Pattern pattern = Pattern.compile("\\d+");
        Splitter splitter = Splitter.on(pattern).omitEmptyStrings();
        splitStrings = splitter.split("abc1fdkal234kfa;kl3");
        for(String singleString : splitStrings) {
            System.out.println(singleString);
        }

//        String[] ss = "abc1fdkal234kfa;kl3".split("\\d+");
//        for(String s : ss) {
//            System.out.println(s);
//        }

        //obtain another Splitter object
        splitter.trimResults().omitEmptyStrings();
        splitStrings = splitter.split("abc1fdkal234kfa;kl3");
        for(String singleString : splitStrings) {
            System.out.println(singleString);
        }


        //can trim any characters and use other methods of CharMatcher can also trim other types.
        splitter = splitter.trimResults(CharMatcher.is('a')).omitEmptyStrings();
        splitStrings = splitter.split("abc1fdkal234kfa;kl3");
        for(String singleString : splitStrings) {
            System.out.println(singleString);
        }
    }
}
