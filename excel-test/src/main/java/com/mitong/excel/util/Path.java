package com.mitong.excel.util;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-13
 */
public class Path {
    public static final String ROOT_PATH = Path.class.getResource("/").getPath();

    public static String getPath(String fileName) {
        return ROOT_PATH + fileName;
    }
}
